package spring.securityBasic.form;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import spring.securityBasic.account.Account;
import spring.securityBasic.account.AccountContext;

import java.util.Collection;

@Service
public class SampleService {
    public void dashboard() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        System.out.println("===================");
        System.out.println(userDetails.getUsername());
        System.out.println(userDetails);
        System.out.println(authentication);

    }
}
