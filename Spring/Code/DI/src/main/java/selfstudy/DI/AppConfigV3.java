package selfstudy.DI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import selfstudy.DI.discount.DiscountPolicy;
import selfstudy.DI.discount.RateDiscountPolicy;
import selfstudy.DI.member.MemberRepository;
import selfstudy.DI.member.MemberService;
import selfstudy.DI.member.MemberServiceImpl;
import selfstudy.DI.member.MemoryMemberRepository;
import selfstudy.DI.order.OrderService;
import selfstudy.DI.order.OrderServiceImpl;

@Configuration
public class AppConfigV3 {
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
