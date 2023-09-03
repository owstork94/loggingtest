package com.sehun.loggingtest.v4;

import com.sehun.loggingtest.trace.TraceStatus;
import com.sehun.loggingtest.trace.logtrace.FieldLogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV4 {

    private final OrderServiceV4 orderServiceV4;

    private final FieldLogTrace fieldLogTrace;

    @GetMapping("v4/request")
    public String request(@RequestParam String itemId){
        TraceStatus Status = null;
        try {
            Status =  fieldLogTrace.begin("OrderControllerv4.request");
            orderServiceV4.orderItem(Status.getTraceId(),itemId);
            fieldLogTrace.end(Status);
            return "OK";
        }catch (Exception e){
            fieldLogTrace.exception(Status, e);
            throw e;
        }


    }
}
