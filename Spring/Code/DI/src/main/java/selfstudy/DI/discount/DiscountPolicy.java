package selfstudy.DI.discount;

import selfstudy.DI.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
