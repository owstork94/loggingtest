package com.sehun.loggingtest.trace.strategy;

import com.sehun.loggingtest.trace.startrace.StartTraceV1;
import com.sehun.loggingtest.trace.strategy.code.strategy.ContextV1;
import com.sehun.loggingtest.trace.strategy.code.strategy.strategy;
import com.sehun.loggingtest.trace.strategy.code.strategy.strategyLogic1;
import com.sehun.loggingtest.trace.strategy.code.strategy.strategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;


@Slf4j
public class ContextV1Test {
    //조립 시점에 변하는 로직 주입 하고 실행(excute)
    void stregyV0(){
        logic1();
        logic2();
    }


    //strategy 패턴 내부 선언
    @Test
    void strategyV1(){
        strategy strategy1 = new strategyLogic1();
        ContextV1 context1 = new ContextV1(strategy1);
        context1.excute();

        strategy strategy2 = new strategyLogic2();
        ContextV1 context2 = new ContextV1(strategy2);
        context2.excute();
    }



    //strategy 패턴 익명클래스 활용
    @Test
    void strategyV2() {
        strategy strategyLogic1 = new strategy() {
            @Override
            public void call() {
                log.info("logic1");
            }
        };
        log.warn("logic1 : {}", strategyLogic1.getClass());
        ContextV1 contextV1 = new ContextV1(strategyLogic1);
        contextV1.excute();
        strategy strategyLoginc2 = new strategy() {
            @Override
            public void call() {
                log.info("logic2");
            }
        };
        log.warn("logic1 : {}", strategyLoginc2.getClass());
        ContextV1 contextV2 = new ContextV1(strategyLoginc2);
        contextV2.excute();
    }

    @Test
    void strategyV3(){
        ContextV1 contextV3 = new ContextV1(new strategy() {
            @Override
            public void call() {
                log.info("v3loginc_1");
            }
        });
        contextV3.excute();

        ContextV1 contextV3_1 = new ContextV1(new strategy() {
            @Override
            public void call() {
                log.info("v3logic_2");
            }
        });
        contextV3_1.excute();



    }

    private void logic2() {
        long startTime = System.currentTimeMillis();
//비즈니스 로직 실행
        log.info("비즈니스 로직1 실행");
//비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    private void logic1() {
        long startTime = System.currentTimeMillis();
//비즈니스 로직 실행
        log.info("비즈니스 로직2 실행");
//비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }
}
