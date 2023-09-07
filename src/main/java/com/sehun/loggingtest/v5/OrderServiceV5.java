package com.sehun.loggingtest.v5;

import com.sehun.loggingtest.trace.TraceStatus;
import com.sehun.loggingtest.trace.logtrace.LogTrace;
import com.sehun.loggingtest.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV5 {
    private final OrderRepositoryV5 orderRepositoryV5;
    private final LogTrace logTrace;

    public Void orderItem(String itemId){
        TraceStatus status = null;
        AbstractTemplate<Void> template = new AbstractTemplate<Void>(logTrace) {
            @Override
            protected Void call() {
                orderRepositoryV5.save(itemId);
                return null;
            }
        };
        return template.excute("OrderRepositoryV4.Request");

    }


}
