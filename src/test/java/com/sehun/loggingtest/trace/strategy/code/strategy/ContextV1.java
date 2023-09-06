package com.sehun.loggingtest.trace.strategy.code.strategy;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContextV1 {
    private strategy strategy;
    public ContextV1(strategy strategy) {
        this.strategy = strategy;
    }

    public void excute(){
        long startTime = System.currentTimeMillis();
        strategy.call();
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("result time = {}",resultTime);
    }


}
