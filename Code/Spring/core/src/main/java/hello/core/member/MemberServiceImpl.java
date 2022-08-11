package hello.core.member;

public class MemberServiceImpl implements MemberService{
    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    // memberRepository는 인터페이스에 의존
    // memberRepository는 구현체에도 의존
    // OCP와 DIP에 어긋남
    private final MemberRepository memberRepository;
    // 설계 변경으로 MemberServiceImpl은 더이상 MemoryMemberRepository에 의존하지 않는다.
    // 단지 MemberRepository 인터페이스에만 의존한다.
    // MemberServiceImpl의 생성자를 통해서 어떤 구현 객체를 주입할지는 오직 AppConfig에서 결정된다.
    // 의존관계에 대한 고민은 외부에 맡기고 실행에만 집중하면 된다.
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
