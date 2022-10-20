package hello.DI.discount;

import hello.DI.member.Grade;
import hello.DI.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_o() {
        //given
        Member member = new Member(1L, "dbgysVIP", Grade.VIP);

        //when
        int discount = discountPolicy.discount(member,10000);

        //then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 10% 할인이 적용되지 않는다.")
    void vip_x() {
        //given
        Member member = new Member(2L, "dbgysBASIC", Grade.BASIC);

        //when
        int discount = discountPolicy.discount(member,10000);

        //then
        assertThat(discount).isEqualTo(0);
    }

}