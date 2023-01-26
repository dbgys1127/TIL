package selfstudy.DI.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import selfstudy.DI.AppConfigV3;
import selfstudy.DI.member.MemberService;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {
    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfigV3 appConfig = new AppConfigV3();
        MemberService memberService1 = appConfig.memberService();

        MemberService memberService2 = appConfig.memberService();

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        assertThat(memberService2).isNotSameAs(memberService1);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체사용")
    public void singletonServiceTest() {
        // 기본 생성자를 private 로 막아서 컴파일 에러가 난다.
//        SingletonService ss = new SingletonService();

        // 호출 시 같은 객체 반환됨
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);
        assertThat(singletonService1).isEqualTo(singletonService2);

        singletonService1.logic();
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {
        // 스프링 컨테이너에 빈을 등록함으로써 스프링이 객체를 싱글톤으로 관리 해준다.
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfigV3.class);

        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        assertThat(memberService1).isSameAs(memberService2);

    }
}
