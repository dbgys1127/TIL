package aop.prac.member;

import aop.prac.member.annotation.ClassAop;
import aop.prac.member.annotation.MethodAop;
import org.springframework.stereotype.Component;

@ClassAop
@Component
public class MemberServiceImpl implements MemberService {

    @Override
    @MethodAop("test value")
    public String hello(String param){
        return "ok";
    }
    public String internal(String param){
        return "ok";
    }
}
