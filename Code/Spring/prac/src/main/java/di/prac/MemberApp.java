package di.prac;
// 회원가입을 회원이 직접 가입한다 생각하고 테스트 해보는 것

import di.prac.member.Grade;
import di.prac.member.Member;
import di.prac.member.MemberService;
import di.prac.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        // 왜 MemoryRepository는 객체를 생성안하냐고????? memberServiceImpl에서 객체를 만들어서 MemoryMemberRepository메서드를 쓰게 해주니까!
        // AppConfig appConfig = new AppConfig();
        // MemberService memberService = appConfig.memberService();

        // 스프링 컨테이너에 접근하기 위한 명령어
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        // 컨테이너에 등록된 빈에 접근하기 위한 명령어
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        Member member = new Member(1L,"memberA", Grade.Vip);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("findMember.getName() = " + findMember.getName());
    }
}
