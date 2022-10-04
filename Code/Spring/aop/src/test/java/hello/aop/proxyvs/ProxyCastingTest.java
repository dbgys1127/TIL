package hello.aop.proxyvs;

import hello.aop.member.MemberService;
import hello.aop.member.MemberServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
public class ProxyCastingTest {

    @Test
    void jdkProxy() {
        MemberServiceImpl target = new MemberServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.setProxyTargetClass(false); // JDK동적 프록시

        //프록시를 인터페이스로 캐스팅 하면 성공
        MemberService proxy =(MemberService) proxyFactory.getProxy();

        //JDK동적 프록시를 구현 클래스로 캐스팅 시도 실패, ClassCastException 예외 발생
        assertThrows(ClassCastException.class,()->{
            MemberServiceImpl castingMemberService = (MemberServiceImpl) proxy;});
    }

    @Test
    void cglibProxy() {
        MemberServiceImpl target = new MemberServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.setProxyTargetClass(true); // CGLIB 프록시

        //프록시를 인터페이스로 캐스팅 하면 성공
        MemberService memberServiceProxy =(MemberService) proxyFactory.getProxy();

        //CGLIB 프록시를 구현 클래스로 캐스팅 시도 실패, ClassCastException 예외 발생
        MemberServiceImpl castingMemberService = (MemberServiceImpl) memberServiceProxy;
    }
}
