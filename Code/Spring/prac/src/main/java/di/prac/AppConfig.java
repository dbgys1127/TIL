package di.prac;

import di.prac.discount.DiscountPolicy;
import di.prac.discount.FixDiscountPolicy;
import di.prac.discount.RateDiscountPolicy;
import di.prac.member.MemberRepository;
import di.prac.member.MemberService;
import di.prac.member.MemberServiceImpl;
import di.prac.member.MemoryMemberRepository;
import di.prac.order.OrderService;
import di.prac.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService(){
        return  new MemberServiceImpl(memberRepository());
    }
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
