package di.prac;

import di.prac.member.Grade;
import di.prac.member.Member;
import di.prac.member.MemberService;
import di.prac.member.MemberServiceImpl;
import di.prac.order.Order;
import di.prac.order.OrderService;
import di.prac.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
        // AppConfig appConfig = new AppConfig();
        // MemberService memberService = appConfig.memberService();
        // OrderService orderService = appConfig.orderService();
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);

        long memberId = 1L;
        Member member = new Member(memberId,"dbgys", Grade.Vip);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"iMac",1000000);

        System.out.println("order = " + order);

    }
}
