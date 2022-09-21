package com.codestates.auth;

import com.codestates.auth.utils.HelloAuthorityUtils;
import com.codestates.exception.BusinessLogicException;
import com.codestates.exception.ExceptionCode;
import com.codestates.member.Member;
import com.codestates.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

/**
 * 데이터베이스에서 조회한 User 의 인증정보를 기반으로 인증처리를 해보자
 * Spring Security에서 제공하는 컴포넌트인 UserDetailsService는 User 정보를 로드하는 핵심 인터페이스이다
 * 로드의 의미는 인증에 필요한 User 정보를 어딘가에서 가지고 온다는 의미, 또 어딘가는 메모리가 될수도있고, 데이터베이스가 될수도 있다.
 * 참고로 User 정보를 등록 하고 관리하는 UserDetailsManager는 UserDetailsService를 상속하는 확장 인터페이스이다.
 */

//@Component
//@RequiredArgsConstructor
//public class HelloUserDetailsServiceV1 implements UserDetailsService {
//    private final MemberRepository memberRepository;
//    //(1) 데이터베이스에서 User를 조회하고, 조회한 User의 권한 정보를 생성하기 위해 주입을 받는다.
//    private final HelloAuthorityUtils authorityUtils;
//
//
//    //(2)
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<Member> optionalMember = memberRepository.findByEmail(username);
//        Member findMember = optionalMember.orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
//
//        //(3) 조회한 회원의 이메일 정보를 이용해 Role기반의 권한 정보 컬렉션을 생성한다.
//        Collection<? extends GrantedAuthority> authorities = authorityUtils.createAuthorities(findMember.getEmail());
//
//        //(4) 권한 정보를 Spring Security 에 전달하고 있다.
//        // 데이터베이스에서 조회한 User 클래스의 객체를 리턴하면 Spring Security가 이 정보를 이용해 인증 절차를 수행한다.(authorities)
//        return new User(findMember.getEmail(), findMember.getPassword(), authorities);
//    }
//}
