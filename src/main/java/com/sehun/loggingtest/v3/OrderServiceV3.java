package com.sehun.loggingtest.v3;

import com.sehun.loggingtest.trace.TraceId;
import com.sehun.loggingtest.trace.TraceStatus;
import com.sehun.loggingtest.trace.logtrace.FieldLogTrace;
import com.sehun.loggingtest.trace.startrace.StartTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV3 {
    private final OrderRepositoryV3 orderRepositoryV3;
    private final FieldLogTrace traceV2;

    public void orderItem(TraceId traceId, String itemId){
        TraceStatus status = null;

        try {
            status = traceV2.begin("OrderServiceV2.orderItem");
            orderRepositoryV3.save(traceId,itemId);
            traceV2.end(status);
        }catch (Exception e){
            traceV2.exception(status,e);
            throw e;
        }

    }


}
