//package spring.securityBasic.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfigV2 extends WebSecurityConfigurerAdapter {
//
//    // 여기서 필터 체인 목록의 기준이 된다.
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http.authorizeRequests()
////                .mvcMatchers("/","/info","/account/**").permitAll()
////                .mvcMatchers("/admin").hasRole("ADMIN")
////                .anyRequest().authenticated();
////                http.formLogin();
////                http.httpBasic();
////    }
//
//}
