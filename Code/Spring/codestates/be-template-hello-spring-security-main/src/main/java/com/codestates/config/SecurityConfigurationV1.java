//package com.codestates.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.provisioning.UserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfigurationV1 {
//
//    @Bean
//    public UserDetailsManager userDetailsService() {
//        /**
//         * (1) 애플리케이션이 실행된 상태에서 사용자 인증을 위한 계정 정보를 메모리 상에 고정된 값으로 설정한 예
//         * 사용자 계정 정보를 메모리 상에 지정했기 때문에 애플리케이션이 실행될 때 마다 사용자 계정정보가 바뀔 일은 없다.
//         * ### 이것은 미리 내부적으로 디폴트 암호를 만드는것
//         */
//        UserDetails user = //(1-1) UserDetails 인터페이스는 인증된 사용자의 핵심정보를 포함하며,
//                // User는 UserDetails의 구현체로 사용자 인증 정보를 생성한다.
//                User.withDefaultPasswordEncoder() // 사용자 패스워드를 암호화 한다. "1111"을 암호화 해준다.
//                .username("dbgys@gmail.com") //(1-2) 여기서는 사용자 이름이 아닌 아이디
//                .password("1111") //(1-3)
//                .roles("USER") //(1-4) 인가하고 관련된 부분이다.
//                .build();
//
//        UserDetails admin = //(1-1) UserDetails 인터페이스는 인증된 사용자의 핵심정보를 포함하며,
//                // User는 UserDetails의 구현체로 사용자 인증 정보를 생성한다.
//                User.withDefaultPasswordEncoder() // 사용자 패스워드를 암호화 한다. "1111"을 암호화 해준다.
//                        .username("admin@gmail.com") //(1-2) 여기서는 사용자 이름이 아닌 아이디
//                        .password("2222") //(1-3)
//                        .roles("ADMIN") //(1-4) 인가하고 관련된 부분이다.
//                        .build();
//
//        return new InMemoryUserDetailsManager(user,admin);//UserDetails를 관리하는 것은 UserDetailsManager이며
//        // InMemoryUserDetailManager은 구현체이다.
//        // 이 구현체와 @Bean 애너테이션을 통해 빈에 등록하고,
//        // 해당 빈이 가지고 있는 사용자의 인증 정보가 클라이언트의 요청으로 넘어오면 정상적인 인증프로세스를 수행한다.
//    }
//    //(1) PasswordEncoder를 빈으로 등록하고 있음(인터페이스)
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        //(1-1)
//        // DelegatingPasswordEncoder가 실질적으로 PasswordEncoder 구현 객체를 생성한다.
//        // ### userDetatilsService는 미리 내부적으로 디폴트 암호를 만드는것
//        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//    }
//
////    @Bean
////    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
////        // HttpSecurity를 통해 Http 요청에 대한 보안 설정을 구성한다. HTTP 요청에 대한 보안 설정을 위한 핵심 클래스이다.
////        // 빈에 등록해서 사용하는 것을 권장함
////        http
////                .csrf().disable() //(1)
////                .formLogin() //(2) 기본 인증 방법을 폼 로그인 방식으로 지정함
////                .loginPage("/auths/login-form") //(3) 우리가 미리 만든 로그인 페이지를 사용하도록 설정->매핑이 되게함(AuthController참고)
////                .loginProcessingUrl("/process_login")
////                //(4) 로그인 인증 요청을 수행할 요청 URL을 지정->login.html에서 form 태그의 action 속성에 지정한 URL
////                // 로그인 버튼을 누르면 /process_login URL로 사용자 인증을 위한 email/password가 전송된다.
////                // 이 URL요청은 Spring Security가 인증 프로세스를 진행한다.
////                .failureUrl("/auths/login-form?error")
////                //(5) 로그인 인증 실패 시 어떤 화면으로 리다이렉트 할것인가 정한다.
////                .and() //(6) Spring Security 보안 설정을 체인 형태로 구성하게 해준다.
////                .authorizeRequests() //(7) 클라이언트의 요청이 들어오면 접근 권한을 확인한다.
////                .anyRequest() //(8)클라이언트의 모든 요청에 대해 접근을 허락한다.
////                .permitAll(); //(9)
////
////        return http.build();
////    }
////    @Bean
////    public SecurityFilterChain filterChain(HttpSecurity http) throws  Exception {
////        http
////                .csrf().disable()
////                .formLogin()
////                .loginPage("/auths/login-form")
////                .loginProcessingUrl("/process_login")
////                .failureUrl("/auths/login-form?error")
////                .and()
////                //(1) 권한이 없는 사용자가 특정 request URI에 접근하면, 403(Forbidden) 에러를 처리하기 위한 페이지 설정
////                //exceptionHandling 메서드는 예외를 처리하는 기능을 한다.
////                //accessDeniedPage는 403에러 발생 시, 파라미터로 지정한 URL로 리다이렉트 되게 한다.
////                .exceptionHandling().accessDeniedPage("/auths/access-denied")
////                .and()
////                //(2)authorizeHttpRequests는 람다표현식으로 request URI에 대한 접근 권한을 부여할 수 있다.
////                //antMatchers 는 ant라는 빌드 툴에서 사용되는 Path Pattern을 이용해서 매치되는 URL을 표현한다.
////                .authorizeHttpRequests(authorize->authorize
////                        //(2-1) hasRole에 지정된 사용자면 antMatchers에 접근할 권한을 주는 것이다.
////                        .antMatchers("/orders/**").hasRole("ADMIN")
////                        //(2-2)
////                        .antMatchers("/members/my-page").hasRole("USER")
////                        //(2-3)
////                        .antMatchers("/**").permitAll());
////        // 접근 허용을 설정할때는 구체적인것부터 와야한다.
////        return http.build();
////    }
//@Bean
//public SecurityFilterChain filterChain(HttpSecurity http) throws  Exception {
//    http
//            .csrf().disable()
//            .formLogin()
//            .loginPage("/auths/login-form")
//            .loginProcessingUrl("/process_login")
//            .failureUrl("/auths/login-form?error")
//            .and()
//            //(1) logout메서드는 로그아웃 설정을 위한 LogoutConfigurer를 리턴한다.
//            .logout()
//            //(2)
//            //사용자가 로그아웃을 수행하기 위한 request URL을 지정한다.
//            .logoutUrl("/logout")
//            //(3)
//            //로그아웃을 성공적으로 했을때, 리다이렉트할 URL을 설정한다.
//            .logoutSuccessUrl("/")
//            .and()
//            .exceptionHandling().accessDeniedPage("/auths/access-denied")
//            .and()
//            .authorizeHttpRequests(authorize->authorize
//                    .antMatchers("/orders/**").hasRole("ADMIN")
//                    .antMatchers("/members/my-page").hasRole("USER")
//                    .antMatchers("/**").permitAll());
//
//    return http.build();
//}
//}
