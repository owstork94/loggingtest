package com.sehun.loggingtest.trace.startrace;

import com.sehun.loggingtest.trace.TraceStatus;
import org.junit.jupiter.api.Test;


class StartTraceV2Test {
    @Test
    void begin_end(){
        StartTraceV2 v2 = new StartTraceV2();
        TraceStatus status = v2.begin("test02");
        v2.end(status);
    }
    @Test
    void exception(){
        StartTraceV2 V2 = new StartTraceV2();
        TraceStatus status = V2.begin("test_exception");
        V2.exception(status,new IllegalArgumentException());
        V2.end(status);
    }

}