package com.sehun.loggingtest.trace.strategy.code.template;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeLogTemplate {

    public void excute(Callback callback){

        Long startTime = System.currentTimeMillis();
        Long endTime = System.currentTimeMillis();

        log.info("start_time : {}",startTime);
        callback.call();
        log.info("emd_time : {}",System.currentTimeMillis());
        log.info("result_time : {}",
                endTime - startTime);


    }
}
