package com.sehun.loggingtest.trace.template;

import com.sehun.loggingtest.trace.TraceStatus;
import com.sehun.loggingtest.trace.logtrace.LogTrace;
import jdk.jshell.Snippet;
import lombok.extern.java.Log;

public abstract class AbstractTemplate<T> {
    private final LogTrace trace;
    public AbstractTemplate(LogTrace trace) {
        this.trace = trace;
    }

    private T excute(String message){
        TraceStatus status = null;
        try {
            status = trace.begin(message);

            T result = call();

            trace.end(status);
            return result;
        }catch (Exception e){
            trace.exception(status,e);
            throw e;
        }
    }
    protected abstract T call();

}
//
//    TraceStatus Status = null;
//        try {
//                Status =  logTrace.begin("OrderControllerV3.request");
//                orderServiceV4.orderItem(itemId);
//                logTrace.end(Status);
//                return "OK";
//                }catch (Exception e){
//                logTrace.exception(Status, e);
//                throw e;
//                }
