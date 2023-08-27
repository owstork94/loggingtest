package com.sehun.loggingtest.v2;

import com.sehun.loggingtest.trace.TraceStatus;
import com.sehun.loggingtest.trace.startrace.StartTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV2 {

    private final OrderServiceV2 orderServiceV2;
    private final StartTraceV1 traceV1;

    @GetMapping("v1/request")
    public String request(@RequestParam String itemId){
        TraceStatus Status = null;
        try {
            Status =  traceV1.begin("OrderControllerV1.request");
            orderServiceV2.orderItem(itemId);
            traceV1.end(Status);
            return "OK";
        }catch (Exception e){
            traceV1.exception(Status, e);
            throw e;
        }


    }
}
