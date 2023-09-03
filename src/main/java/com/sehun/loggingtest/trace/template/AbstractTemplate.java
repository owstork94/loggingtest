package com.sehun.loggingtest.trace.template;

import com.sehun.loggingtest.trace.TraceStatus;
import com.sehun.loggingtest.trace.logtrace.FieldLogTrace;
import com.sehun.loggingtest.trace.logtrace.LogTrace;

public abstract class AbstractTemplate<T>{
    private final LogTrace logTrace;
    public AbstractTemplate(LogTrace logTrace) {
        this.logTrace = logTrace;
    }


    public T excute(String message){
        TraceStatus status = null;
        try {
            status = logTrace.begin(message);

            //바뀌는 로직
            T result = call();

            logTrace.end(status);
        return result;
        }catch (Exception e){
            logTrace.exception(status,e);


        };

    }

    protected abstract T call();
}
