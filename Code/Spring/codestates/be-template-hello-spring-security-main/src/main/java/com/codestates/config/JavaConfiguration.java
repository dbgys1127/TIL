package com.codestates.config;

import com.codestates.auth.utils.HelloAuthorityUtils;
import com.codestates.member.DBMemberService;
//import com.codestates.member.InMemoryMemberService;
import com.codestates.member.MemberRepository;
import com.codestates.member.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
public class JavaConfiguration {
    //(1) MemberService인터페이스 구현체인 InMemoryMemberService 클래스의 빈 객체를 생성한다.
    //InMemoryMemberService클래스는 데이터베이스 연동 없이 메모리에 Spring Security의 User를 등록해야 하므로
    // UserDetailsManager 객체가 필요하다.
    // 또한, User 등록 시, 패스워드를 암호화 한 후에 등록해야 하므로 PasswordEncoder 객체가 필요하다.
    // 따라서 InMemoryMemberService객체 생성 시 DI를 해준다.
//    @Bean
//    public MemberService inMemoryMemberService(UserDetailsManager userDetailsManager,
//                                               PasswordEncoder passwordEncoder) {
//        return new InMemoryMemberService(userDetailsManager,passwordEncoder);
//    }

    /**
     * 데이터베이스에 User 정보를 저장하기 위해, DBMemberService로 변경 했다.
     * @param memberRepository
     * @param passwordEncoder
     * @return
     */
    @Primary
    @Bean
    public MemberService dbMemberService(MemberRepository memberRepository,
                                               PasswordEncoder passwordEncoder,
                                         HelloAuthorityUtils authorityUtils) {
        return new DBMemberService(memberRepository,passwordEncoder,authorityUtils);
        // 데이터베이스에 저장해야 함으로 MemberRepository를 주입받았다.
    }
}
