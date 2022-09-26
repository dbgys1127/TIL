package com.cos.security1.config.auth;

import com.cos.security1.model.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * 시큐리티가 /login 주소 요청이 오면 낚아채서 로그인을 진행시킨다.
 * 로그인 진행이 완료가 되면 시큐리티 session을 만들어준다.(SecurityContextHolder)
 * 오브젝트 => Authentication 타입의 객체 가 session에 들어갈 수 있다.
 * Authentication 안에 User정보가 있어야 됨.
 * User 객체의 타입은 => UserDetails 타입 객체이다.
 * Security Sesssion => 여기 들어 갈 수 있는 객체가 Authentication => UserDetails타입이 Authentication이 들어갈 수 있다.
 * UserDetails=PrincipalDetails
 *
 */
@Data
public class PrincipalDetails implements UserDetails, OAuth2User {

    private User user; //콤포지션
    private Map<String,Object> attributes;

    //일반로그인 할때 사용하는 생성자
    public PrincipalDetails(User user) {
        this.user = user;
    }

    //OAuth 로그인 할때 쓰는 생성자
    public PrincipalDetails(User user, Map<String, Object> attributes) {
        this.user = user;
        this.attributes = attributes;
    }

    //해당 User의 권한을 리턴하는 곳!!!
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collet = new ArrayList<>();
        collet.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return user.getRole();
            }
        });
        return collet;
    }
    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }


    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        //우리 사이트에서 1년동안 회원이 로그인을 안하면 휴면 계정으로 하기로 했다.
        return true;
    }

    @Override
    public String getName() {
        //쓰지도 않음
        //return attributes.get("sub");
        return null;
    }
}
