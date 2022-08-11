package hello.core.member;

public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // memberRepository는 인터페이스에 의존
    // memberRepository는 구현체에도 의존
    // OCP와 DIP에 어긋남
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
