package com.cos.security1.config.auth;

import com.cos.security1.model.User;
import com.cos.security1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

/**
 * 시큐리티 설정에서 .loginProcessingUrl("/login")을 걸어 놔서
 *  '/login' 요청이 오면 자동으로 UserDetailsService 타입으로 IoC(여기서 제어한다)되어 있는 loadUserByUsername 함수가 실행
 */
@Service
public class PrincipalDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;


    // 시큐리티 session => Authentication => UserDetails(PrincipalDetails는 UserDetails 자식)
    // Authentication(내부 UserDetails)
    // 시큐리티 session(내부 Authtication(내부 UserDetails))
    // 이 메서드가 호출되면 UserDetails가 Authentication에 들어간다.

    //함수 종료시 @AuthenticationPrincipal 어노테이션이 만들어 진다.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 여기서 username은 폼에서 등록한 username(유저 아이디)가 넘어 온다.
        User userEntity =userRepository.findByUsername(username);

        if(userEntity!=null){
            return new PrincipalDetails(userEntity);
        }
        return null;
    }
}
