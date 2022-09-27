package com.cos.jwt.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.cos.jwt.auth.PrincipalDetails;
import com.cos.jwt.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.rsocket.RSocketSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Date;

//스프링 시큐리티에서 UsernamePasswordAuthenticationFilter가 있음.
// /login 요청해서 username, password 전송을 하면 (post)
// UsernamePasswordAuthenticationFilter가 동작함
// 지금 안하는 건 formLogin을 disable해서 이다.
// 이 필터를 다시 SecurityConfig에 등록해야 함
@Slf4j
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;

    // /login 요청을 하면 로그인 시도를 위해서 실행되는 함수

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        log.info("JwtAuthenticationFilter 로그인 시도중");

        //1.username,password 받아서
        try {
            ObjectMapper om = new ObjectMapper();
            User user = om.readValue(request.getInputStream(), User.class);
            System.out.println("user = " + user);

            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());

            //2.정상인지 로그인 시도를 해보는 거에요. authenticationManager로 로그인 시도를 하면, PrincipalDetailsService가 호출하면
            // loadUserByUsername() 함수가 실행된 후 정상이면 authentication이 리턴됨.
            // DB에 있는 username과 password가 일치한다.
            Authentication authentication =
                    authenticationManager.authenticate(authenticationToken);

            PrincipalDetails principalDetails =(PrincipalDetails) authentication.getPrincipal();
            log.info("login success username={}",principalDetails.getUser().getUsername()); // 로그인 정상 수행됨.

            //3. 로그인이 정상으로 되면 PrincipalDetails를 세션에 담고(권한 관리를 위해서 필요하다)
            //authentication 객체가 session영역에 저장됨.
            // 그 방법을 리턴해줌
            // 리턴의 이유는 권한 관리를 security가 대신 해주기 때문에 편하려고 하는거
            // 굳이 JWT토큰을 사용하면서 세션을 만들 이유가 없는데, 단지 권한 처리 때문에 session에 넣어 준다.
            return authentication;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //attemptAuthentication 실행 후 인증이 정상적으로 되었으면 successfulAuthentication함수가 실행된다.
    //4. JWT를 여기서 토큰을 만들어서 request 요청한 사용자에게 JWT토큰을 response해주면 된다.
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        log.info("인증이 완료되었습니다.");

        PrincipalDetails principalDetails =(PrincipalDetails) authResult.getPrincipal();

        //principleDetails이용해서 JWT 만들꺼임

        //Hash암호 방식
        String jwtToken = JWT.create()
                .withSubject("cos토큰")
                .withExpiresAt(new Date(System.currentTimeMillis() + (60000 * 10)))
                .withClaim("id", principalDetails.getUser().getId())
                .withClaim("username", principalDetails.getUser().getUsername())
                .sign(Algorithm.HMAC512("cos"));

        // 유저네임, 패스워드 로그인 정상

        //서버쪽 세션 id 생성
        //클라이언트 쿠키 세션아이디를 응답

        //요청할 때마다 쿠키값 세션아이디를 항상 들고 서버쪽으로 요청하기 때문에, 서버는 세션아이디가 유효한지 판단해서 유효하면 인증이 필요한 페이지로 접근하게 됨

        // 유저네임, 패스워드 로그인 정상
        //JWT토큰을 생성
        // 클라이언트 쪽으로 JWT토큰을 응답

        // 요청할 때마다 JWT토큰을 가지고 요청
        //서버는 JWT토큰이 유효한지를 판단 하는 필터를 만들어주자

        response.addHeader("Authorization","Bearer "+jwtToken);
    }
}
