package selfstudy.DI.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import selfstudy.DI.AppConfigV3;
import selfstudy.DI.member.MemberRepository;
import selfstudy.DI.member.MemberServiceImpl;
import selfstudy.DI.order.OrderServiceImpl;

public class ConfigurationSingletonTest {
    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfigV3.class);
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        System.out.println("memberService->memberRepository" + memberService.getMemberRepository());
        System.out.println("orderService->memberRepository" + orderService.getMemberRepository());
        System.out.println("memberRepository" + memberRepository);

        Assertions.assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
        Assertions.assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
    }
}
