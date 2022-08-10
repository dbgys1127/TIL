package com.codestates;

import com.codestates.repository.JdbcTemplateMemberRepository;
import com.codestates.repository.JpaMemberRepository;
import com.codestates.repository.MemberRepository;
import com.codestates.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private final MemberRepository memberRepository;
    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }
//    @Bean
//    public MemberRepository memberRepository(){
////        return new MemoryMemberRepository();
//       // return new JdbcMemberRepository(dataSource);
//        // return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }
}
