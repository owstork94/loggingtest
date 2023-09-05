package com.sehun.loggingtest.v3;

import com.sehun.loggingtest.trace.TraceId;
import com.sehun.loggingtest.trace.TraceStatus;
import com.sehun.loggingtest.trace.logtrace.FieldLogTrace;
import com.sehun.loggingtest.trace.logtrace.LogTrace;
import com.sehun.loggingtest.trace.startrace.StartTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV3 {
    private final OrderRepositoryV3 orderRepositoryV3;
    private final LogTrace logTrace;

    public void orderItem(String itemId){
        TraceStatus status = null;

        try {
            status = logTrace.begin("OrderServiceV2.orderItem");
            orderRepositoryV3.save(itemId);
            logTrace.end(status);
        }catch (Exception e){
            logTrace.exception(status,e);
            throw e;
        }

    }


}
