package com.sehun.loggingtest.v5;

import com.sehun.loggingtest.trace.TraceStatus;
import com.sehun.loggingtest.trace.callback.TraceCallback;
import com.sehun.loggingtest.trace.callback.TraceTemplate;
import com.sehun.loggingtest.trace.logtrace.LogTrace;
import com.sehun.loggingtest.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderControllerV5 {
    private final OrderServiceV5 orderServiceV5;
    private final TraceTemplate template;

    public OrderControllerV5(OrderServiceV5 orderServiceV5, TraceTemplate template) {
        this.orderServiceV5 = orderServiceV5;
        this.template = template;
    }

        @GetMapping("v5/request")
        public String request(String itemId){
        return (String) template.excute("ctrl.request", new TraceCallback<>(){
            @Override
            public String call() {
                orderServiceV5.orderItem(itemId);
                return "OK";
            }
        });
        }
}
