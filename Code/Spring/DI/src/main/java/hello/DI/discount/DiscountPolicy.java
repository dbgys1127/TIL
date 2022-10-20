package hello.DI.discount;

import hello.DI.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
