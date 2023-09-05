package com.sehun.loggingtest.v4;

import com.sehun.loggingtest.trace.TraceStatus;
import com.sehun.loggingtest.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV4 {

    private final OrderServiceV4 orderServiceV4;

    /*private final FieldLogTrace fieldLogTrace;*/

    private final LogTrace logTrace;

    @GetMapping("v4/request")
    public String request(@RequestParam String itemId){
        
        TraceStatus Status = null;
        try {
            Status =  logTrace.begin("OrderControllerV3.request");
            orderServiceV4.orderItem(itemId);
            logTrace.end(Status);
            return "OK";
        }catch (Exception e){
            logTrace.exception(Status, e);
            throw e;
        }


    }
}
