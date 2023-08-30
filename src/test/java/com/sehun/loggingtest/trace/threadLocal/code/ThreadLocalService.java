package com.sehun.loggingtest.trace.threadLocal.code;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLocalService {
    //name 파라미터로 받아서 로그 출력 후 nameSpace 에 저장 하고 1초 쉬고 로그 뱉고 리턴
    private ThreadLocal<String> nameSpace = new ThreadLocal<>();
    public String Loging(String name) throws InterruptedException {
        log.info("저장 name = {} -> nameSpace = {}", name,nameSpace.get());
        nameSpace.set(name);
        sleep(1000);
        log.info("조회 nameSpace = {}",nameSpace.get());
        return nameSpace.get();
    }

    private void sleep(int milis) throws InterruptedException {
        Thread.sleep(milis);
    }
}
