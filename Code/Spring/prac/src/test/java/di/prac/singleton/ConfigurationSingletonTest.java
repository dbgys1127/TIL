package di.prac.singleton;

import di.prac.AppConfig;
import di.prac.member.MemberServiceImpl;
import di.prac.member.MemoryMemberRepository;
import di.prac.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {
    @Test
    void configurationTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemoryMemberRepository memberRepository = ac.getBean("memberRepository", MemoryMemberRepository.class);

        System.out.println("memberService -> memberRepository = "+ memberService.getMemberRepository());
        System.out.println("orderService -> memberRepository = "+ orderService.getMemberRepository());
        System.out.println("memberRepository = "+memberRepository);

        Assertions.assertThat(memberService.getMemberRepository()).isSameAs(orderService.getMemberRepository());
    }
}
