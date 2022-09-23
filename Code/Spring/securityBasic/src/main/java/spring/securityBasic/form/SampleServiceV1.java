package spring.securityBasic.form;

import org.springframework.stereotype.Service;

@Service
public class SampleServiceV1 {
    public void dashboard() {
//        //현재 로그인 정보를 참고 하고 싶다.
//        // SecurityContextHoleder내에 Authentication이 있다.
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        //Authentication안에 Principal이 있다.
//        // UserDetails를 구현한 우리가 만든 User객체가 반환
//        Object principal = authentication.getPrincipal();
//
//        //사용자가(Principal) 가진 권한도 Authentication 안에 있다.
//        //GrantAuthority라는 컬렉션 타입의 권한이 있다. 권한은 여러개일수 있으므로
//        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
//        Object credentials = authentication.getCredentials();
//
//        //인증이 되었는가?
//        boolean authenticated = authentication.isAuthenticated();
    }
}
