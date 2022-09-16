package com.codestates.slice.controller.member;

import com.codestates.member.entity.Member;
import com.codestates.member.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void saveMemberTest() {
        // given
        Member member = new Member();
        member.setEmail("hgd@gmail.com");
        member.setName("홍길동");
        member.setPhone("010-1111-2222");

        // when
        Member savedMember = memberRepository.save(member);

        // then
        assertNotNull(savedMember);
        assertTrue(member.getEmail().equals(savedMember.getEmail()));
        assertTrue(member.getName().equals(savedMember.getName()));
        assertTrue(member.getPhone().equals(savedMember.getPhone()));
    }

    @Test
    public void findByEmailTest() {
        // given
        Member member = new Member();
        member.setEmail("hgd@gmail.com");
        member.setName("홍길동");
        member.setPhone("010-1111-2222");


        // when
        memberRepository.save(member);
        Optional<Member> findMember = memberRepository.findByEmail(member.getEmail());

        // then
        assertTrue(findMember.isPresent());
        assertTrue(findMember.get().getEmail().equals(member.getEmail()));
    }
}
