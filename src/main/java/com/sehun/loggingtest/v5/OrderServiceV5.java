package com.sehun.loggingtest.v5;

import com.sehun.loggingtest.trace.TraceStatus;
import com.sehun.loggingtest.trace.callback.TraceCallback;
import com.sehun.loggingtest.trace.callback.TraceTemplate;
import com.sehun.loggingtest.trace.logtrace.LogTrace;
import com.sehun.loggingtest.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV5 {

    private final OrderRepositoryV5 orderRepositoryV5;
    //    private final LogTrace logTrace;
    private final TraceTemplate template;

    @Autowired
    public OrderServiceV5(OrderRepositoryV5 orderRepositoryV5, @Qualifier("logTrace") LogTrace trace) {
        this.orderRepositoryV5 = orderRepositoryV5;
        this.template = new TraceTemplate(trace);
    }



    public Void orderItem(String itemId){

        template.excute("service.request",()->{
            orderRepositoryV5.save(itemId);
            return null;
        });
//        TraceStatus status = null;



//        AbstractTemplate<Void> template = new AbstractTemplate<Void>(logTrace) {
//            @Override
//            protected Void call() {
//                orderRepositoryV5.save(itemId);
//                return null;
//            }
//        };
//        return template.excute("OrderRepositoryV5.Request");

        return null;
    }


}
