package spring.securityBasic.account;

import org.springframework.security.test.context.support.WithMockUser;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@WithMockUser(username = "dbgys",roles = "USER")
@Retention(RetentionPolicy.RUNTIME)
public @interface WithUser {
}
