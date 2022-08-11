package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();
        // MemberService memberService = new MemberServiceImpl();

        //스프링 컨테이너에 어노테이션 붙인애들 다 넣는다.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //꺼낼때
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.Vip);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("findMember =" + findMember.getName());
        System.out.println("new member = " + member.getName());
    }
}
