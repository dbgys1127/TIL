package hello.DI;

import hello.DI.discount.DiscountPolicy;
import hello.DI.discount.FixDiscountPolicy;
import hello.DI.discount.RateDiscountPolicy;
import hello.DI.member.MemberRepository;
import hello.DI.member.MemberService;
import hello.DI.member.MemberServiceImpl;
import hello.DI.member.MemoryMemberRepository;
import hello.DI.order.OrderService;
import hello.DI.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {


    //우리 service 통합해서 만들때 참고
    @Bean
    public MemberService memberService(){
        System.out.println("AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public OrderService orderService() {
        System.out.println("AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public MemberRepository memberRepository() {
        System.out.println("AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }
    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}
