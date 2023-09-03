package com.sehun.loggingtest.v4;

import com.sehun.loggingtest.trace.TraceId;
import com.sehun.loggingtest.trace.TraceStatus;
import com.sehun.loggingtest.trace.logtrace.FieldLogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
@RequiredArgsConstructor
@Repository
public class OrderRepositoryV4 {

    private final FieldLogTrace traceV4;

    public void save(TraceId traceId, String itemId){
        TraceStatus status = null;

        try {
            status = traceV4.begin("OrderRepositoryV4.save");
            if (itemId.equals("ex")){
                throw new IllegalArgumentException("throw exception");
            }
            sleep(2000);
            traceV4.end(status);
        }catch (Exception e){
            traceV4.exception(status,e);
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

