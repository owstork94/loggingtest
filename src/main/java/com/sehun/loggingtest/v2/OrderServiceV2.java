package com.sehun.loggingtest.v2;

import com.sehun.loggingtest.trace.TraceId;
import com.sehun.loggingtest.trace.TraceStatus;
import com.sehun.loggingtest.trace.startrace.StartTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV2 {
    private final OrderRepositoryV2 orderRepositoryV2;
    private final StartTraceV2 traceV2;

    public void orderItem(TraceId traceId, String itemId){
        TraceStatus status = null;

        try {
            status = traceV2.beginSync(traceId,"OrderServiceV2.orderItem");
            orderRepositoryV2.save(traceId,itemId);
            traceV2.end(status);
        }catch (Exception e){
            traceV2.exception(status,e);
            throw e;
        }

    }


}
