package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.strategy.ContextV1;
import hello.advanced.trace.strategy.code.strategy.Strategy;
import hello.advanced.trace.strategy.code.strategy.StrategyLogic1;
import hello.advanced.trace.strategy.code.strategy.StrategyLogic2;
import hello.advanced.trace.template.code.AbstractTemplate;
import hello.advanced.trace.template.code.SubClassLogic1;
import hello.advanced.trace.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV1Test {
    @Test
    void strategyV0() {
        logic1();
        logic2();
    }
    private void logic1() {
        long startTime = System.currentTimeMillis();
        //비즈니스 로직 실행
        log.info("비즈니스 로직1 실행");
        //비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime-startTime;
        log.info("resultTime = {}",resultTime);
    }

    private void logic2() {
        long startTime = System.currentTimeMillis();
        //비즈니스 로직 실행
        log.info("비즈니스 로직2 실행");
        //비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime-startTime;
        log.info("resultTime = {}",resultTime);
    }
    /**
     * 템플릿 메서드 패턴 적용
     */
    @Test
    void templateMethodV1() {
        AbstractTemplate template1 = new SubClassLogic1();
        template1.excute();

        AbstractTemplate template2 = new SubClassLogic2();
        template2.excute();
    }
    @Test
    void templateMethodV2() {
        AbstractTemplate template1=new AbstractTemplate(){

            @Override
            protected void call() {
                log.info("비즈니스 로직1 실행");
            }
        };
        log.info("클래스 이름1={}",template1.getClass());
        template1.excute();
        AbstractTemplate template2=new AbstractTemplate(){

            @Override
            protected void call() {
                log.info("비즈니스 로직2 실행");
            }
        };
        log.info("클래스 이름2={}",template2.getClass());
        template2.excute();

    }

    /**
     * 전략 패턴 사용
     */
    @Test
    void starategyV1() {
        StrategyLogic1 strategyLogic1 = new StrategyLogic1();
        ContextV1 context1 = new ContextV1(strategyLogic1);
        context1.excute();

        StrategyLogic2 strategyLogic2 = new StrategyLogic2();
        ContextV1 context2 = new ContextV1(strategyLogic2);
        context2.excute();
    }
    /**
     * 전략 패턴 익명 내부클래스 적용
     */
    @Test
    void strategyV2() {
       Strategy strategyLogic1= new Strategy(){
            @Override
            public void call() {
                log.info("비즈니스 로직1 실행");
            }
        };
        ContextV1 context1 = new ContextV1(strategyLogic1);
        context1.excute();

        Strategy strategyLogic2= new Strategy(){
            @Override
            public void call() {
                log.info("비즈니스 로직2 실행");
            }
        };
        ContextV1 context2 = new ContextV1(strategyLogic2);
        context2.excute();
    }

    @Test
    void strategyV3() {

        ContextV1 context1 = new ContextV1(new Strategy(){
            @Override
            public void call() {
                log.info("비즈니스 로직1 실행");
            }
        });
        context1.excute();


        ContextV1 context2 = new ContextV1(new Strategy(){
            @Override
            public void call() {
                log.info("비즈니스 로직2 실행");
            }
        });
        context2.excute();
    }
    @Test
    void strategyV4() {

        ContextV1 context1 = new ContextV1(() -> log.info("비즈니스 로직1 실행"));
        context1.excute();


        ContextV1 context2 = new ContextV1(() -> log.info("비즈니스 로직2 실행"));
        context2.excute();
    }
}
