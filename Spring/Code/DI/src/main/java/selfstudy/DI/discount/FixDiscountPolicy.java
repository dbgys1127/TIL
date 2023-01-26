package selfstudy.DI.discount;

import org.springframework.stereotype.Component;
import selfstudy.DI.member.Grade;
import selfstudy.DI.member.Member;


public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
