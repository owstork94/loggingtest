package com.sehun.loggingtest.trace.strategy.code.strategy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class strategyLogic2 implements strategy{
    @Override
    public void call() {
      log.warn("비즈니스 로직2 실행");
    }
}
