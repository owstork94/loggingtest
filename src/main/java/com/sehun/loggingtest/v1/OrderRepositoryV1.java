package com.sehun.loggingtest.v1;

import com.sehun.loggingtest.trace.TraceStatus;
import com.sehun.loggingtest.trace.startrace.StartTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
@RequiredArgsConstructor
@Repository
public class OrderRepositoryV1 {

    private final StartTraceV1 traceV1;

    public void save(String itemId){
        TraceStatus status = null;

        try {
            status = traceV1.begin("OrderRepositoryV1.save");
            if (itemId.equals("ex")){
                throw new IllegalArgumentException("throw exception");
            }
            sleep(1000);
            traceV1.end(status);
        }catch (Exception e){
            traceV1.exception(status,e);
            throw e;
        }

    }

    public void sleep(int mile){
        try {
            Thread.sleep(mile);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}

