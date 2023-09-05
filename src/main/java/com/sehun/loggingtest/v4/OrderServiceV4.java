package com.sehun.loggingtest.v4;

import com.sehun.loggingtest.trace.TraceStatus;
import com.sehun.loggingtest.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV4 {
    private final OrderRepositoryV4 orderRepositoryV4;
    private final LogTrace logTrace;

    public void orderItem(String itemId){
        TraceStatus status = null;

        try {
            status = logTrace.begin("OrderServiceV2.orderItem");
            orderRepositoryV4.save(itemId);
            logTrace.end(status);
        }catch (Exception e){
            logTrace.exception(status,e);
            throw e;
        }

    }


}
