package com.sehun.loggingtest.trace.logtrace;

import com.sehun.loggingtest.trace.TraceStatus;

public interface LogTrace {

    TraceStatus begin(String message);
    void end(TraceStatus status);
    void exception(TraceStatus status, Exception e);
}
