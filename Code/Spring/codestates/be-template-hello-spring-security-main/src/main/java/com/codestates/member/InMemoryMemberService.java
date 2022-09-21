//package com.codestates.member;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.UserDetailsManager;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RequiredArgsConstructor
//public class InMemoryMemberService implements MemberService {
//    private final UserDetailsManager userDetailsManager;
//    private final PasswordEncoder passwordEncoder;
//
//    /**
//     * 회원 가입 정보를 전달 받아 Spring Security의 User를 메모리에 등록해 주는 InMemoryMemberService 클래스 코드이다.
//     * 이제껏 @Service 애너테이션으로 빈에 등록했지만, 여기서는 JavaConfiguration클래스에서 생성자에 @Bean애너테이션이 붙었기때문에
//     * InMemoryMemberService가 빈에 등록된다.
//     * @param member
//     * @return
//     */
//    @Override
//    public Member createMember(Member member) {
//        //(3) User의 권한 목록을 List<GrantedAuthority> 로 생성하고 있다.
//        // SimpleGrantedAuthority(3-1)을 사용해서 Role을 지정할떄 'Roll_'+권한명 형태로 해야 권한 매핑이 된다.
//        List<GrantedAuthority> authorities = createAuthorities(Member.MemberRole.ROLE_USER.name());
//
//        //(4) 반드시 암호화 해야한다 안하면 에러 발생!
//        String encryptedPassword = passwordEncoder.encode(member.getPassword());
//
//        //(5)
//        UserDetails userDetails = new User(member.getEmail(), encryptedPassword, authorities);
//
//        //(6) User를 등록
//        userDetailsManager.createUser(userDetails);
//
//        return member;
//    }
//
//    private List<GrantedAuthority> createAuthorities(String... roles) {
//        //(3-1)
//        return Arrays.stream(roles)
//                .map(role->new SimpleGrantedAuthority(role))
//                .collect(Collectors.toList());
//    }
//}
