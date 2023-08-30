package com.sehun.loggingtest.trace.startrace;

import com.sehun.loggingtest.trace.TraceId;
import com.sehun.loggingtest.trace.TraceStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StartTraceV1 {

    private static final String START_PREFIX = "--->";
    private static final String COMPLETE_PREFIX = "<--";
    private static final  String EX_PREFIX = "<X-";

    private TraceId traceIdHolder;

    public TraceStatus begin(String message){
        syncTraceId();

        TraceId traceId = new TraceId();
        Long startTimeMs = System.currentTimeMillis();
        log.info("[{}] {}{}",traceId.getId(),addSpace(START_PREFIX,
                traceId.getLevel()),message);
        //로그 시작 시 값 세팅
        return new TraceStatus(traceId,startTimeMs,message);
    }

    public void end(TraceStatus status){complete(status,null);};

    public void exception(TraceStatus status, Exception e){complete(status, e);}

    private void complete(TraceStatus status, Exception e) {
        //완료 : 결과 시간 = 정지시간 - 시작시간
        //level 만큼 공백 추가 하여 래밸에 따른 로그 출력
        //exception 발생하면 그에 맞는 로그 출력

        Long stopTimeMs = System.currentTimeMillis();
        long resultTimeMs = stopTimeMs - status.getStartTimeMs();
        TraceId traceId = status.getTraceId();

        if(e == null){
            //정상
            log.info("[{}] {}{} time={}ms",traceId.getId(),addSpace(COMPLETE_PREFIX,traceId.getLevel()),status.getMessage(),resultTimeMs);
        }else {
            log.info("[{}] {}{} time={}ms ex={}", traceId.getId(),
                    addSpace(EX_PREFIX, traceId.getLevel()), status.getMessage(), resultTimeMs,
                    e.toString());
        }

//        releaseTraceId();
    }

    private void syncTraceId() {
        if(traceIdHolder == null){
            traceIdHolder = new TraceId();
        }else{
            traceIdHolder = traceIdHolder.createNextId();
        }
    }
    private void releaseTraceId() {
        if(traceIdHolder.isFirstLevel()){
            traceIdHolder = null;
        }else {
            traceIdHolder = traceIdHolder.createpreviousId();
        }
    }

    private Object addSpace(String completePrefix, int level) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < level; i++){
            sb.append(i == (level - 1) ? "|"+ completePrefix : "|  " );
        }
        return sb.toString();
    }



}
