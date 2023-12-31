package com.sehun.loggingtest.v2;

import com.sehun.loggingtest.trace.TraceId;
import com.sehun.loggingtest.trace.TraceStatus;
import com.sehun.loggingtest.trace.startrace.StartTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
@RequiredArgsConstructor
@Repository
public class OrderRepositoryV2 {

    private final StartTraceV2 traceV2;

    public void save(TraceId traceId, String itemId){
        TraceStatus status = null;

        try {
            status = traceV2.beginSync(traceId,"OrderRepositoryV2.save");
            if (itemId.equals("ex")){
                throw new IllegalArgumentException("throw exception");
            }
            sleep(2000);
            traceV2.end(status);
        }catch (Exception e){
            traceV2.exception(status,e);
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

