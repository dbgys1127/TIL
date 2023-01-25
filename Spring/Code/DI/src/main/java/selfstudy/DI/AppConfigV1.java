package selfstudy.DI;

import selfstudy.DI.discount.FixDiscountPolicy;
import selfstudy.DI.member.MemberService;
import selfstudy.DI.member.MemberServiceImpl;
import selfstudy.DI.member.MemoryMemberRepository;
import selfstudy.DI.order.OrderService;
import selfstudy.DI.order.OrderServiceImpl;

public class AppConfigV1 {
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }
    public OrderService orderService() {
        return new OrderServiceImpl(
                new MemoryMemberRepository(),
                new FixDiscountPolicy());
    }
}
