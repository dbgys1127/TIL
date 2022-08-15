package di.prac.discount;

import di.prac.member.Grade;
import di.prac.member.Member;
import org.springframework.stereotype.Component;

@Component
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
