package com.sehun.loggingtest.v3;

import com.sehun.loggingtest.trace.TraceStatus;
import com.sehun.loggingtest.trace.logtrace.FieldLogTrace;
import com.sehun.loggingtest.trace.logtrace.LogTrace;
import com.sehun.loggingtest.trace.logtrace.ThreadLocalLogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV3 {

    private final OrderServiceV3 orderServiceV3;

    /*private final FieldLogTrace fieldLogTrace;*/

    private final LogTrace logTrace;

    @GetMapping("v3/request")
    public String request(@RequestParam String itemId){
        
        TraceStatus Status = null;
        try {
            Status =  logTrace.begin("OrderControllerV3.request");
            orderServiceV3.orderItem(itemId);
            logTrace.end(Status);
            return "OK";
        }catch (Exception e){
            logTrace.exception(Status, e);
            throw e;
        }


    }
}
