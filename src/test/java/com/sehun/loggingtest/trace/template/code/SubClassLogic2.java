package com.sehun.loggingtest.trace.template.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SubClassLogic2 extends AbstractTemplate{
    @Override
    protected void call() {
        log.info("Template Method 패턴 2 실행");
    }
}
