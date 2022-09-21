package com.codestates.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws  Exception {
        http
                //(1) 웹브라우저에서 H2 웹 콘솔을 정상적으로 사용하기 위한 설정
                //frameOptions()는 HTML 태그 중 <frame>,<iframe>,<object> 태그에서 페이지를 렌더링 할지 결정하는 기능
                //HTML 태그를 이용한 페이지 렌더링을 허용하지 않겠다는 뜻이다.-> Clickjacking 공격에 대한 방어책
                //여기에 sameOrigin을 추가하면 동일한 출처로부터 들어오는 request만 페이지 렌더링을 허용한다.
                .headers().frameOptions().sameOrigin()
                .and()
                .csrf().disable()
                .formLogin()
                .loginPage("/auths/login-form")
                .loginProcessingUrl("/process_login")
                .failureUrl("/auths/login-form?error")
                .and()
                //(1) logout메서드는 로그아웃 설정을 위한 LogoutConfigurer를 리턴한다.
                .logout()
                //(2)
                //사용자가 로그아웃을 수행하기 위한 request URL을 지정한다.
                .logoutUrl("/logout")
                //(3)
                //로그아웃을 성공적으로 했을때, 리다이렉트할 URL을 설정한다.
                .logoutSuccessUrl("/")
                .and()
                .exceptionHandling().accessDeniedPage("/auths/access-denied")
                .and()
                .authorizeHttpRequests(authorize->authorize
                        .antMatchers("/orders/**").hasRole("ADMIN")
                        .antMatchers("/members/my-page").hasRole("USER")
                        .antMatchers("/**").permitAll());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        //(1-1)
        // DelegatingPasswordEncoder가 실질적으로 PasswordEncoder 구현 객체를 생성한다.
        // ### userDetatilsService는 미리 내부적으로 디폴트 암호를 만드는것
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
