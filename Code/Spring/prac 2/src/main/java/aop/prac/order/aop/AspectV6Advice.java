package aop.prac.order.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Slf4j
@Aspect
public class AspectV6Advice {
    @Around("aop.prac.order.aop.Pointcuts.orderAndService()")
    public Object doTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
        try{
            //before
            log.info("[트랜잭션 시작] {}",joinPoint.getSignature());
            Object result = joinPoint.proceed();
            //AfterReturning
            log.info("[트랙잭션 커밋] {}",joinPoint.getSignature());
            return result;
        }catch (Exception e){
            //AfterThrowing
            log.info("[트랜잭션 롤백] {}",joinPoint.getSignature());
            throw e;
        }finally {
            //After
            log.info("[트랜잭션 릴리즈] {}",joinPoint.getSignature());
        }
    }
    @Before("aop.prac.order.aop.Pointcuts.orderAndService()")
    public void doBefore(JoinPoint joinPoint){
        log.info("[before] {}",joinPoint.getSignature());
    }
    @AfterReturning(value = "aop.prac.order.aop.Pointcuts.orderAndService()",returning = "result")
    public void doReturn(JoinPoint joinPoint, Object result){
        log.info("[return] {} return = {}",joinPoint.getSignature(),result);
    }

    @AfterThrowing(value = "aop.prac.order.aop.Pointcuts.orderAndService()",throwing = "ex")
    public void doThrowing(JoinPoint joinPoint, Exception ex){
        log.info("[ex] {} message = {}",joinPoint.getSignature(),ex.getMessage());
    }

    @After("aop.prac.order.aop.Pointcuts.orderAndService()")
    public void doAfter(JoinPoint joinPoint){
        log.info("[after] {}",joinPoint.getSignature());
    }
}
