package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    // 문제점 할인정책을 바꾸려면 클라이언트에 클래스(구현)을 바꿔야한다.
    // 인터페이스에 의존하지만 구체(구현)클래스에도 의존하고있다.
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    private final DiscountPolicy discountPolicy;
    private final MemberRepository memberRepository;
    //설계 변경으로 OrderServiceImpl은 FixDiscountPolicy에 의존하지 않는다.
    // 단지 DiscountPolicy 인터페이스에만 의존한다.
    // OrderServiceImpl 입장에서 생성자를 통해 어떤 구현 객체가 들어올지 알 수 없다.
    // OrderServiceImpl의 생성자를 통해서 어떤 구현 객체를 주입할지는 오직 외부 AppConfig에서 결정한다.
    // OrderServiceImpl은 오직 실행에만 집중하면 된다.
    public OrderServiceImpl(DiscountPolicy discountPolicy, MemberRepository memberRepository) {
        this.discountPolicy = discountPolicy;
        this.memberRepository = memberRepository;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member =memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
