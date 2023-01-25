package selfstudy.DI;

import selfstudy.DI.discount.DiscountPolicy;
import selfstudy.DI.discount.RateDiscountPolicy;
import selfstudy.DI.member.MemberRepository;
import selfstudy.DI.member.MemberService;
import selfstudy.DI.member.MemberServiceImpl;
import selfstudy.DI.member.MemoryMemberRepository;
import selfstudy.DI.order.OrderService;
import selfstudy.DI.order.OrderServiceImpl;

public class AppConfigV2 {
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
