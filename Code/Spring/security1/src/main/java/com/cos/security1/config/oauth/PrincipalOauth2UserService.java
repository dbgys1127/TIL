package com.cos.security1.config.oauth;

import com.cos.security1.config.auth.PrincipalDetails;
import com.cos.security1.model.User;
import com.cos.security1.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {
    // 구글로 부터 받은 userRequest 데이터에 대한 후처리되는 함수

    @Autowired
    private UserRepository userRepository;

    //구글로 부터 받은 userRequest데이터에 대한 후처리되는 함수
    //함수 종료시 @AuthenticationPrincipal 어노테이션이 만들어 진다.
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        // 우리 서버의 기본 정보 registration으로 어떤 Oauth로 로그인 할 수 있는지 파악
        log.info("userRequest.ClientRegistration = {}",userRequest.getClientRegistration());
        log.info("userRequest.AccessToken = {}",userRequest.getAccessToken().getTokenValue());

        OAuth2User oAuth2User = super.loadUser(userRequest);

        // 구글로그인 버트 클릭 -> 구글 로그인창 -> 로그인 완료 ->code를 리턴(OAuth-Client라는 라이브러리가 받음)->AccessToken요청
        // 여기 까지가 userRequest정보
        // 이 userRequest정보로 -> loadUser함수 호출 해서 -> 구글로 부터 회원 프로필을 받음
        log.info("userRequest.getAttributes = {}",oAuth2User.getAttributes());// 이정보를 토대로 회원가입 강제 진행하게됨

        String provider= userRequest.getClientRegistration().getClientId();// google
        String prividerId = oAuth2User.getAttribute("sub");//110985656123035269477
        String username = provider+"_"+prividerId; //google_110985656123035269477,
        //String password = bCryptPasswordEncoder.encode("겟인데어"); //user 객체를 위해 쓸뿐 크게 의미 없다.
        String email = oAuth2User.getAttribute("email");//110985656123035269477
        String role = "ROLE_USER";

        User userEntity = userRepository.findByUsername(username);

        if (userEntity == null) {
            log.info("구글 로그인이 최초입니다.");
            userEntity = User.builder()
                    .username(username)
                    //.password(password)
                    .email(email)
                    .role(role)
                    .provider(provider)
                    .providerId(prividerId)
                    .build();
            userRepository.save(userEntity);
        } else {
            log.info("구글 로그인을 이미 한적이 있습니다. 당신은 자동회원가입이 되어있습니다.");
        }

        // 이 반환 값이 Authentication에 저장된다. 원래 load... 은 오버라이드 안해도 되는데 이 것을 정해주기 위해 오버라이드하는 것이다.
        // 즉 다형성 적용을 위해 오버라이드 함
        // 또함 OAuth 로그인 시 attribute를 User객체에 맞추기 위함
        return new PrincipalDetails(userEntity,oAuth2User.getAttributes());
    }
}

