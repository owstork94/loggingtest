package com.sehun.loggingtest.trace.threadLocal.code;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FieldService {
    //name 파라미터로 받아서 로그 출력 후 nameSpace 에 저장 하고 1초 쉬고 로그 뱉고 리턴
    private String nameSpace;
    public String Loging(String name) throws InterruptedException {
        log.info("저장 name = {} -> nameSpace = {}", name,nameSpace);
        nameSpace = name;
        sleep(1000);
        log.info("조회 nameSpace = {}",nameSpace);
        return nameSpace;
    }

    private void sleep(int milis) throws InterruptedException {
        Thread.sleep(milis);
    }
}
