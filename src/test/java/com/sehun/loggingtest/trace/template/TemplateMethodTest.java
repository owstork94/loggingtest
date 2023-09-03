package com.sehun.loggingtest.trace.template;

import com.sehun.loggingtest.trace.template.code.AbstractTemplate;
import com.sehun.loggingtest.trace.template.code.SubClassLogic1;
import com.sehun.loggingtest.trace.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateMethodTest {


    void templateMethodV0(){
        loginc1();
        loginc2();
    }



    @Test
    void templateMethodV1(){
        AbstractTemplate abstractTemplate1 = new SubClassLogic1();
        abstractTemplate1.excute();
        AbstractTemplate abstractTemplate2 = new SubClassLogic2();
        abstractTemplate2.excute();

    }
    @Test
    void templateMdthodV2(){
        AbstractTemplate abstractTemplate1_1 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("Template Method 패턴1");
            }
        };
        abstractTemplate1_1.excute();
        log.info("getClass-1 {}",abstractTemplate1_1.getClass());

        AbstractTemplate abstractTemplate1_2 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("Template Method 패턴2");
            }
        };
        abstractTemplate1_2.excute();
        log.info("getClass-2 {}",abstractTemplate1_1.getClass());
    }

    private void loginc1() {
        long startTime = System.currentTimeMillis();
//비즈니스 로직 실행
        log.info("비즈니스 로직1 실행");
//비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    private void loginc2() {
        long startTime = System.currentTimeMillis();
//비즈니스 로직 실행
        log.info("비즈니스 로직2 실행");
//비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }


}
