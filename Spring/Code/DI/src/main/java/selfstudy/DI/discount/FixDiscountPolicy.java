package selfstudy.DI.discount;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import selfstudy.DI.annotation.MainDiscountPolicy;
import selfstudy.DI.member.Grade;
import selfstudy.DI.member.Member;


@Component
@MainDiscountPolicy
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
