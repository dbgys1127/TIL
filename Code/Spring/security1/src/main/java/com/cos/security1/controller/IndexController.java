package com.cos.security1.controller;

import com.cos.security1.config.auth.PrincipalDetails;
import com.cos.security1.model.User;
import com.cos.security1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequiredArgsConstructor
public class IndexController {
    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/test/login")
    public @ResponseBody String testLogin(Authentication authentication
    , @AuthenticationPrincipal UserDetails userDetails) { //DI 하면 Authentication안에 Principal 객체가 있는데 이것을 다운 캐스팅 해서 확인
        log.info("/test/login ==========");
        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
        log.info("authentication ={}",principalDetails.getUser());

        log.info("userDetails = {}",userDetails.getUsername());
        return "세션 정보 확인하기";
    }
    @GetMapping("/test/oauth/login")
    public @ResponseBody String testOAuthLogin(Authentication authentication
            , @AuthenticationPrincipal OAuth2User oAuth) {
        // 이 둘로 모두 객체 프로필에 접근 할 수 있다. 객체 타입을 OAuth2User로 다운케스팅 해야 한다.
        log.info("/test/oauth/login ==========");
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        log.info("authentication ={}",oAuth2User.getAttributes());
        log.info("oauth2User = {}",oAuth.getAttributes());

        return "OAuth 세션정보 확인하기";
    }

    @GetMapping({"","/"})
    public String index() {
        //머스테치 기본폴더 src/main/resources/
        //뷰리졸버 설정 : templates(prefix).mustache // 생략가능
        return "index";
    }
    //OAuth 로그인을 해도 PrincipalDetails
    //일반 로그인을 해도 PrincipalDetails
    @GetMapping("/user")
    public @ResponseBody String user(@AuthenticationPrincipal PrincipalDetails principalDetails) {
        log.info("principalDetails = {} ", principalDetails.getUser());
        return "user";
    }
    @GetMapping("/admin")
    public @ResponseBody String admin() {
        return "admin";
    }
    @GetMapping("/manager")
    public @ResponseBody String manager() {
        return "manager";
    }

    //스프링 시큐리티 해당주소를 낚아챘는데, Security Config 파일 생성 후 작동 안한다.
    @GetMapping("/loginForm")
    public String loginForm() {
        return "loginForm";
    }

    @GetMapping("/joinForm")
    public String joinForm() {
        return "joinForm";
    }

    @PostMapping("/join")
    public String join(@ModelAttribute User user) {
        System.out.println(user);
        user.setRole("ROLE_USER");
        String rawPassword = user.getPassword();
        String encPassword =bCryptPasswordEncoder.encode(rawPassword);
        user.setPassword(encPassword);

        userRepository.save(user);
        //회원가입 잘됨. 비밀번호 : 1234 => 시큐리티로 로그인을 할 수 없음. 이유는 패스워드가 암호화가 안되었기 때문
        return "redirect:/loginForm";
    }

    @Secured("ROLE_ADMIN") //하나만 권한을 줄수 있다.
    @GetMapping("/info")
    public @ResponseBody String info() {
        return "개인정보";
    }
    @PreAuthorize("hasRole('ROLE_MANAGER')or hasRole('ROLE_ADMIN')")
    //@PostAuthorize는 함수가 끝나고 나서 판단한다.
    //여러 권한을 줄때 사이
    //이 메서드 실행 직전에 판단함
    @GetMapping("/data")
    public @ResponseBody String data() {
        return "데이터 정보";
    }
}
