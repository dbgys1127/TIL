package di.prac.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //회원이 사용할때, 가입하고 싶다고 하면, 멤버객체를 memberRepository에 저장한다.
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }
    // 회원이 정보를 조회할때는, memberRepository에 아이디를 전닳하면, findById메소드에서 아이디를 키값으로 회원 객체를 가져온다.
    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
