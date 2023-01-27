package selfstudy.DI.autowired;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import selfstudy.DI.AutoAppConfig;
import selfstudy.DI.DiscountService;
import selfstudy.DI.discount.DiscountPolicy;
import selfstudy.DI.member.Grade;
import selfstudy.DI.member.Member;

import java.util.List;
import java.util.Map;

public class AllBeanTest {
    @Test
    void findAllBean() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        DiscountService discountService = ac.getBean(DiscountService.class);
        Member member = new Member(1L, "userA", Grade.VIP);
        int discountPrice = discountService.discount(member,10000,"fixDiscountPolicy");
    }

}
