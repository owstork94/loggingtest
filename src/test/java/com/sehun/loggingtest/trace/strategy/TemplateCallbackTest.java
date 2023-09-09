package com.sehun.loggingtest.trace.strategy;

import com.sehun.loggingtest.trace.strategy.code.template.Callback;
import com.sehun.loggingtest.trace.strategy.code.template.TimeLogTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateCallbackTest {
//실행 시점(excute)에 변하는 로직 주입
    @Test
    void callbackV1(){
        TimeLogTemplate timeLogTemplate = new TimeLogTemplate();

        

        timeLogTemplate.excute(new Callback() {
            @Override
            public void call() {
                log.info("log_1");
            }
        });

        timeLogTemplate.excute(new Callback() {
            @Override
            public void call() {
                log.info("log_2");
            }
        });

        TimeLogTemplate timeLogTemplate2 = new TimeLogTemplate();

        timeLogTemplate2.excute(()-> log.info("Ramda_log_1"));
        timeLogTemplate2.excute(()-> log.info("Ramda_log_2"));
    }
}
