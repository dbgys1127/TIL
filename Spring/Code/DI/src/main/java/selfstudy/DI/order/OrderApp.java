package selfstudy.DI.order;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import selfstudy.DI.AppConfigV1;
import selfstudy.DI.AppConfigV3;
import selfstudy.DI.member.Grade;
import selfstudy.DI.member.Member;
import selfstudy.DI.member.MemberService;

public class OrderApp {
    public static void main(String[] args) {
//        AppConfigV1 appConfig = new AppConfigV1();
//        OrderService orderService = appConfig.orderService();
//        MemberService memberService = appConfig.memberService();
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfigV3.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(1L, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
