package com.sehun.loggingtest.v4;

import com.sehun.loggingtest.trace.TraceId;
import com.sehun.loggingtest.trace.TraceStatus;
import com.sehun.loggingtest.trace.logtrace.FieldLogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV4 {
    private final OrderRepositoryV4 orderRepositoryV4;
    private final FieldLogTrace traceV4;

    public void orderItem(TraceId traceId, String itemId){
        TraceStatus status = null;

        try {
            status = traceV4.begin("OrderServiceV4.orderItem");
            orderRepositoryV4.save(traceId,itemId);
            traceV4.end(status);
        }catch (Exception e){
            traceV4.exception(status,e);
            throw e;
        }

    }


}
