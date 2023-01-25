package selfstudy.DI.member;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import selfstudy.DI.AppConfigV3;

import static org.assertj.core.api.Assertions.*;

class MemberServiceTest {
    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AppConfigV3 appConfig = new AppConfigV3();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        // given
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }
}