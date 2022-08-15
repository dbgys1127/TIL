package di.prac.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository implements MemberRepository{
    private static Map<Long, Member> store = new HashMap<>();
    // 메모리 저장소에는 map에 회원 아이디와 회원 객체 저장
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }
    // 회원 정보를 찾을 때는 회원 아이디를 키값으로 회원 객체를 꺼냄
    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
