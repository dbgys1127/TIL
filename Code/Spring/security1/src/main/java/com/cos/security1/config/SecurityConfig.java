package com.cos.security1.config;


import com.cos.security1.config.oauth.PrincipalOauth2UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;





@Configuration
@EnableWebSecurity // 스프링 시큐리티 필터가 스프링 필터체인에 등록이 된다.
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
//@EnableGlobalMethodSecurity는 글로벌로 설정을 하겠다인데, 그중에 몇 메소드에만 걸고 싶을때 아래 옵션을 쓴다.
// secured 어노테이션 활성 어노테이션 활성화
//prePostAuthorize는 여러개 권한 주고 싶 을때 된다. 이거 하나만 설정해주면 PreAuthorize와 PostAuthorize를 둘다 활성화 해준다.
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PrincipalOauth2UserService principalOauth2UserService;
    // 해당 메서드의 리턴되는 객체를 Ioc로 등록해준다.
    @Bean
    public BCryptPasswordEncoder encodePwd() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/user/**").authenticated()//인증만 되면 들어갈 수 있는 주소
                .antMatchers("/manager/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')")
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/loginForm")
                .loginProcessingUrl("/login")// '/login' 주소가 호출이 되면 시큐리티가 낚아채서 대신 로그인을 진행해준다.
                .defaultSuccessUrl("/")//로그인이 완료되면 루트페이지로 간다.
                .and()
                .oauth2Login()
                .loginPage("/loginForm")
                .userInfoEndpoint()
                .userService(principalOauth2UserService);
        // 구글 로그인이 완료되고 후처리가 필요함. ***Tip. 코드받는 것도 아니고, 엑세스토큰 + 사용자 프로필정보를 받는다.***
        // 1. 코드 받기(인증),
        // 2.엑세스토큰(권한),
        // 3. 사용자프로필 정보를 가져와서,
        // 4-1. 그정보를 토대로 회원가입을 자동으로 진행시키기도 함
        // 4-2. 구글이 갖고 있는 프로필이 이메일, 전화번호, 이름, 아이디가 있는데 내가 쇼핑몰을 운영하면
        // 4-3. 집주소, 고객등급 같은 추가 프로필 정보가 필요하게 되면, 자동 회원가입이 아닌 추가 회원가입 창이 필요하다.
        // 4-4. 기본으로 필요하다면 추가 회원가입 창이 필요없다.
        // 우리는 자동회원 가입으로 갈꺼다.
    }
}
