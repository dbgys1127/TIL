package com.codestates.auth.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Role 기반의 User 권한을 생성하기 위해 사용한 클래스이다.
 */
@Component
public class HelloAuthorityUtils {
    //(1) application.yml에 추가한 프로퍼티를 가져오는 표현식이다.
    // 관리자 권한을 가질 수 있는 이메일 주소를 불러 오고 있다.
    @Value("${mail.address.admin}")
    private String adminMailAddress;

    //(2) AuthorityUtils 클래스를 이용해서 사용 권한 목록을 List<GrantedAuthority>객체로 미리 생성한다.
    private final List<GrantedAuthority> ADMIN_ROLES = AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_USER");

    private final List<GrantedAuthority> USER_ROLES = AuthorityUtils.createAuthorityList("ROLE_USER");

    private final List<String> ADMIN_ROLES_STRING = List.of("ADMIN","USER");
    private final List<String> USER_ROLES_STRING  = List.of("USER");

    public List<GrantedAuthority> createAuthorities(String email) {
        //(3) 관리자 권한 메일과 동일하면, 관리자 권한을 준다.
        if (email.equals(adminMailAddress)) {
            return ADMIN_ROLES;
        }
        return USER_ROLES;
    }
    public List<GrantedAuthority> createAuthorities(List<String> roles) {
        List<GrantedAuthority> authorities =roles.stream()
                .map(role->new SimpleGrantedAuthority("ROLE_"+role))
                .collect(Collectors.toList());
        return authorities;
    }
    public List<String> createRoles(String email) {
        //(3) 관리자 권한 메일과 동일하면, 관리자 권한을 준다.
        if (email.equals(adminMailAddress)) {
            return ADMIN_ROLES_STRING;
        }
        return USER_ROLES_STRING;
    }
}
