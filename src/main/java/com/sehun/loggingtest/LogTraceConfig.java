package com.sehun.loggingtest;

import com.sehun.loggingtest.trace.logtrace.LogTrace;
import com.sehun.loggingtest.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {
    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }
}
