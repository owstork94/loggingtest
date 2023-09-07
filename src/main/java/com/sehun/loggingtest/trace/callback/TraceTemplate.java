package com.sehun.loggingtest.trace.callback;

import com.sehun.loggingtest.trace.TraceStatus;
import com.sehun.loggingtest.trace.logtrace.LogTrace;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TraceTemplate<T>{

    private final LogTrace trace;

    public TraceTemplate(LogTrace trace) {
        this.trace = trace;
    }
    public <T> T excute(String message, TraceCallback<T> callback) {
        TraceStatus status = null;
        try {
            status = trace.begin(message);

            T result = callback.call();

            trace.end(status);

            return result;

        } catch (Exception e) {
            trace.exception(status, e);
            throw  e;
        }
    }


}
//
//
//
//    TraceStatus Status = null;
//        try {
//                Status =  traceV1.begin("OrderControllerV1.request");
//                orderServiceV1.orderItem(itemId);
//                traceV1.end(Status);
//                return "OK";
//                }catch (Exception e){
//                traceV1.exception(Status, e);
//                throw e;
//                }