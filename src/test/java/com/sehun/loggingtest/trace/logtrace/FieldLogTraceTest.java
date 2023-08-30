package com.sehun.loggingtest.trace.logtrace;

import com.sehun.loggingtest.trace.TraceStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FieldLogTraceTest {

    FieldLogTrace fieldLogTrace = new FieldLogTrace();
    @Test
    void begin_end_level2() {
        TraceStatus status1 = fieldLogTrace.begin("test01-1");
        TraceStatus status2 = fieldLogTrace.begin("test01-2");
        fieldLogTrace.end(status2);
        fieldLogTrace.end(status1);
    }

//    @Test
//    void end() {
//    }
//
//    @Test
//    void exception() {
//    }
}