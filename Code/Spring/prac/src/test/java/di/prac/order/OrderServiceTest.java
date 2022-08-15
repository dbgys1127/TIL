package di.prac.order;

import di.prac.AppConfig;
import di.prac.member.Grade;
import di.prac.member.Member;
import di.prac.member.MemberService;
import di.prac.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){
        long memberId = 1L;
        Member member = new Member(memberId,"dbgys", Grade.Vip);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"iMac",20000);
        Assertions.assertThat(order.caluculatePrice()).isEqualTo(18000);
    }
}
