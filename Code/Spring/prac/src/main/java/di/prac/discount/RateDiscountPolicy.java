package di.prac.discount;

import di.prac.annotation.MainDiscountPolicy;
import di.prac.member.Grade;
import di.prac.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("mainDiscountPolicy")
//@Primary
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy{
    private int discountPercent = 10;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.Vip){
            return price*discountPercent/100;
        }else {
            return 0;
        }
    }
}
