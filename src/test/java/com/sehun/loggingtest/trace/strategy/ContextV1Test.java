package com.sehun.loggingtest.trace.strategy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContextV1Test {
    void stregyV0(){
        logic1();
        logic2();
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
