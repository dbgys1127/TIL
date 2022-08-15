package di.prac.beanfind;

import di.prac.AppConfig;
import di.prac.member.MemberService;
import di.prac.member.MemberServiceImpl;
import di.prac.order.OrderService;
import di.prac.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {
    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName("이름 없이 타입만으로 조회")
    void findBeanByType(){
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2(){
        //하위가 상위로 변환 될수 있어도, 상위가 하위로 변환 될 수 없다.
        // OrderServiceImpl - OrderServiceImpl 0 , OrderServiceImpl - OrderService x
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        assertThat(orderService).isInstanceOf(OrderServiceImpl.class);
    }
    @Test
    @DisplayName("빈 이름으로 조회 x")
    void findBeanByNameX(){
        assertThrows(NoSuchBeanDefinitionException.class,
                ()->ac.getBean("x", MemberService.class));
    }
}
