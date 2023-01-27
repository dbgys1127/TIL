package selfstudy.DI;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import selfstudy.DI.discount.DiscountPolicy;
import selfstudy.DI.member.Member;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class DiscountService {
    private final Map<String, DiscountPolicy> policyMap;
    private final List<DiscountPolicy> policies;


    public int discount(Member member, int price, String discountCode) {
        System.out.println("policyMap = " + policyMap);
        System.out.println("policies = " + policies);
        DiscountPolicy discountPolicy = policyMap.get(discountCode);
        System.out.println("discountCode = " + discountCode);
        System.out.println("discountPolicy = " + discountPolicy);
        return discountPolicy.discount(member, price);
    }
}
