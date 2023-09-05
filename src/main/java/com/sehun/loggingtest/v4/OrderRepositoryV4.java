package com.sehun.loggingtest.v4;

import com.sehun.loggingtest.trace.TraceStatus;
import com.sehun.loggingtest.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
@RequiredArgsConstructor
@Repository
public class OrderRepositoryV4 {

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
    }

    public void sleep(int mile){
        try {
            Thread.sleep(mile);
        }catch (InterruptedException e){
            throw new IllegalArgumentException();
        }
    }

}

