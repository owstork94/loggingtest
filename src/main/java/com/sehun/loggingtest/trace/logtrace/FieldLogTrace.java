package com.sehun.loggingtest.trace.logtrace;

import com.sehun.loggingtest.trace.TraceId;
import com.sehun.loggingtest.trace.TraceStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Slf4j
@Component
public class FieldLogTrace implements LogTrace{
    private static final String START_PREFIX = "--->";
    private static final String COMPLETE_PREFIX = "<--";
    private static final  String EX_PREFIX = "<X-";

    private TraceId traceIdHolder;
    @Override
    public TraceStatus begin(String message) {
        syncTraceId();
        TraceId traceId = traceIdHolder;
        Long startTimeSec = System.currentTimeMillis();
        log.info("[{}] {}{}", traceId.getId(), addSpace(START_PREFIX,
                traceId.getLevel()), message);
        return new TraceStatus(traceId,startTimeSec,message);
    }

    //traceId 가 없는 경우(최초 호출) 새로 생성, 그렇지 않으면 다음 래벨로 생성
    private void syncTraceId() {

        traceIdHolder = (traceIdHolder == null) ? new TraceId() : traceIdHolder.createNextId();
//            log.info("initialization: {}", traceIdHolder.getId());
//        if (traceIdHolder == null){
//            traceIdHolder = new TraceId();
//        }else {
//            traceIdHolder =   traceIdHolder.createNextId();
//        }
    }

    private static String addSpace(String prefix, int level) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) {
            sb.append( (i == level - 1) ? "|" + prefix : "| ");
        }
        return sb.toString();
    }

    @Override
    public void end(TraceStatus status) {
        complate(status, null);
    }

    private void complate(TraceStatus status, Exception e) {
        Long stopTimeMs = System.currentTimeMillis();
        long resultTimeMs = stopTimeMs - status.getStartTimeMs();
        TraceId traceId = status.getTraceId();
        if (e == null) {
            log.info("[{}] {}{} time={}ms", traceId.getId(),
                    addSpace(COMPLETE_PREFIX, traceId.getLevel()), status.getMessage(),
                    resultTimeMs);
        } else {
            log.info("[{}] {}{} time={}ms ex={}", traceId.getId(),
                    addSpace(EX_PREFIX, traceId.getLevel()), status.getMessage(), resultTimeMs,
                    e.toString());
        }
        relaaseTraceId();
    }

    private void relaaseTraceId() {

        traceIdHolder = traceIdHolder.isFirstLevel() ? null : traceIdHolder.createpreviousId();
//        if (traceIdHolder.isFirstLevel()){
//            traceIdHolder = null;
//            log.info("destroy");
//        }else {
//            traceIdHolder = traceIdHolder.createpreviousId();
//        }

    }

    @Override
    public void exception(TraceStatus status, Exception e) {
        complate(status, e);
    }
}
