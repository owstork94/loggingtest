package com.sehun.loggingtest.v3;

import com.sehun.loggingtest.trace.TraceStatus;
import com.sehun.loggingtest.trace.logtrace.FieldLogTrace;
import com.sehun.loggingtest.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
@RequiredArgsConstructor
@Repository
public class OrderRepositoryV3 {

    private final LogTrace logTrace;

    public void save(String itemId){
        TraceStatus status = null;

        try {
            status = logTrace.begin("OrderRepositoryV2.save");
            if (itemId.equals("ex")){
                throw new IllegalArgumentException("throw exception");
            }
            sleep(2000);
            logTrace.end(status);
        }catch (Exception e){
            logTrace.exception(status,e);
            throw e;
        }
//         13b97222] OrderControllerV3.request
//         13b97222] |--->OrderServiceV2.orderItem
//         13b97222] | |--->OrderRepositoryV2.save
//        [13b97222]<--OrderRepositoryV2.save time=2007ms
//        [13b97222]<--OrderServiceV2.orderItem time=2008ms
//        [13b97222] OrderControllerV3.request time=2008ms
    }

    public void sleep(int mile){
        try {
            Thread.sleep(mile);
        }catch (InterruptedException e){
            throw new IllegalArgumentException();
        }
    }

}

