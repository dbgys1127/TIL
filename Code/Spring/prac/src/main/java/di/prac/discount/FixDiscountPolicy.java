package di.prac.discount;

import di.prac.member.Grade;
import di.prac.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.Vip){
            return discountFixAmount;
        }else{
            return 0;
        }
    }
}
