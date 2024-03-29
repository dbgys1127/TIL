package selfstudy.DI.order;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import selfstudy.DI.annotation.MainDiscountPolicy;
import selfstudy.DI.discount.DiscountPolicy;
import selfstudy.DI.discount.FixDiscountPolicy;
import selfstudy.DI.member.Member;
import selfstudy.DI.member.MemberRepository;
import selfstudy.DI.member.MemoryMemberRepository;

@Component
public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository;
//    @Qualifier("mainDiscountPolicy")
    private final DiscountPolicy discountPolicy ;

    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
