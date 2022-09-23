//package spring.securityBasic.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.Ordered;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//
//@Configuration
//@Order(Ordered.LOWEST_PRECEDENCE-15)
//public class SecurityConfigV3 extends WebSecurityConfigurerAdapter {
//
//    // 여기서 필터 체인 목록의 기준이 된다.
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.antMatcher("/**")
//                .authorizeRequests()
//                .mvcMatchers("/","/info","/account/**").permitAll()
//                .anyRequest().authenticated();
//        http.formLogin();
//        http.httpBasic();
//    }
//
//}
