package com.sehun.loggingtest.v2;

import com.sehun.loggingtest.trace.TraceStatus;
import com.sehun.loggingtest.trace.startrace.StartTraceV1;
import com.sehun.loggingtest.trace.startrace.StartTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV2 {

    private final OrderServiceV2 orderServiceV2;
    private final StartTraceV2 traceV2;

    @GetMapping("v2/request")
    public String request(@RequestParam String itemId){
        TraceStatus Status = null;
        try {
            Status =  traceV2.begin("OrderControllerV2.request");
            orderServiceV2.orderItem(Status.getTraceId(),itemId);
            traceV2.end(Status);
            return "OK";
        }catch (Exception e){
            traceV2.exception(Status, e);
            throw e;
        }


    }
}
