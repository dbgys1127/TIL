package di.prac.discount;

import di.prac.member.Grade;
import di.prac.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용됩니다.")
    void vip_o(){
        //given
        Member member = new Member(1L,"dbgys", Grade.Vip);

        //when
        int discount = discountPolicy.discount(member,5000);

        //then
        assertThat(discount).isEqualTo(500);
    }

    @Test
    @DisplayName("Basic은 할인이 적용안됩니다.")
    void vip_x(){
        Member member = new Member(2L,"dbgys1127",Grade.Basic);

        int discount = discountPolicy.discount(member,1000);

        assertThat(discount).isEqualTo(0);
    }
}
