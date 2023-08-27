package com.sehun.loggingtest.v2;

import com.sehun.loggingtest.trace.TraceStatus;
import com.sehun.loggingtest.trace.startrace.StartTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV2 {
    private final OrderRepositoryV2 orderRepositoryV2;
    private final StartTraceV1 traceV1;

    public void orderItem(String itemId){
        TraceStatus status = null;
        try {
            status = traceV1.begin("OrderServiceV1.orderItem");
            orderRepositoryV2.save(itemId);
            traceV1.end(status);
        }catch (Exception e){
            traceV1.exception(status,e);
            throw e;
        }

    }


}
