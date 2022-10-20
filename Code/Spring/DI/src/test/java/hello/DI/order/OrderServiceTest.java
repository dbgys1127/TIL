package hello.DI.order;

import hello.DI.AppConfig;
import hello.DI.member.Grade;
import hello.DI.member.Member;
import hello.DI.member.MemberService;
import hello.DI.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

    MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

    OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

    @Test
    void createOrder() {
        long memberId =1L;
        Member member = new Member(memberId, "dbgys2", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}