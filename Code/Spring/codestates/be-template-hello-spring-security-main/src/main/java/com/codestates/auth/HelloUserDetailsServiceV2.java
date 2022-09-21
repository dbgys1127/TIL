//package com.codestates.auth;
//
//import com.codestates.auth.utils.HelloAuthorityUtils;
//import com.codestates.exception.BusinessLogicException;
//import com.codestates.exception.ExceptionCode;
//import com.codestates.member.Member;
//import com.codestates.member.MemberRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import java.util.Collection;
//import java.util.Optional;
//
///**
// * 데이터베이스에서 조회한 User 의 인증정보를 기반으로 인증처리를 해보자
// * Spring Security에서 제공하는 컴포넌트인 UserDetailsService는 User 정보를 로드하는 핵심 인터페이스이다
// * 로드의 의미는 인증에 필요한 User 정보를 어딘가에서 가지고 온다는 의미, 또 어딘가는 메모리가 될수도있고, 데이터베이스가 될수도 있다.
// * 참고로 User 정보를 등록 하고 관리하는 UserDetailsManager는 UserDetailsService를 상속하는 확장 인터페이스이다.
// */
//
//@Component
//@RequiredArgsConstructor
//public class HelloUserDetailsServiceV2 implements UserDetailsService {
//    private final MemberRepository memberRepository;
//    private final HelloAuthorityUtils authorityUtils;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<Member> optionalMember = memberRepository.findByEmail(username);
//        Member findMember = optionalMember.orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
//
//        //(1)
//        return new HelloUserDetails(findMember);
//    }
//
//    //(2)
//    private final class HelloUserDetails extends Member implements UserDetails {
//        //(2-1)
//        //(2-2)
//        HelloUserDetails(Member member) {
//            setMemberId(member.getMemberId());
//            setFullName(member.getName());
//            setEmail(member.getEmail());
//            setPassword(member.getPassword());
//        }
//
//        @Override
//        public Collection<? extends GrantedAuthority> getAuthorities() {
//            //(2-3)
//            return authorityUtils.createAuthorities(this.getEmail());
//        }
//
//        //(2-4)
//        @Override
//        public String getUsername() {
//            return getEmail();
//        }
//
//        @Override
//        public boolean isAccountNonExpired() {
//            return true;
//        }
//
//        @Override
//        public boolean isAccountNonLocked() {
//            return true;
//        }
//
//        @Override
//        public boolean isCredentialsNonExpired() {
//            return true;
//        }
//
//        @Override
//        public boolean isEnabled() {
//            return true;
//        }
//    }
//}
