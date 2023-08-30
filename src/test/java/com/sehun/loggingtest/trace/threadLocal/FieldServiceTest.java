package com.sehun.loggingtest.trace.threadLocal;

import com.sehun.loggingtest.trace.threadLocal.code.FieldService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j

public class FieldServiceTest {
    private FieldService fieldService = new FieldService();

    @Test
    void Field() throws InterruptedException {
        log.info("main start");
        Runnable userAN = new Runnable() {
            @Override
            public void run() {
                try {
                    fieldService.Loging("userA");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable userA = () -> {
            try {
                fieldService.Loging("userA");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Runnable userB = () -> {
            try {
                fieldService.Loging("userB");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Thread threadA = new Thread(userA);
        threadA.setName("user-A");
        Thread threadB = new Thread(userB);
        threadB.setName("user-B");

        threadA.start();
//        sleep(2000);//동시상 ok
        sleep(100);
        threadB.start();
        sleep(3000);
        log.info("main exit");
    }

    private void sleep(int i) throws InterruptedException {
        Thread.sleep(i);
    }
}
