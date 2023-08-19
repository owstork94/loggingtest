package com.sehun.loggingtest.trace.startrace;

import com.sehun.loggingtest.trace.TraceStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class StartTraceV1Test {
    @Test
    void begin_end(){
        StartTraceV1 v1 = new StartTraceV1();
        TraceStatus status = v1.begin("test01");
        v1.end(status);
    }
    @Test
    void exception(){
        StartTraceV1 v1 = new StartTraceV1();
        TraceStatus status = v1.begin("test_exception");
        v1.exception(status,new IllegalArgumentException());
        v1.end(status);
    }

}