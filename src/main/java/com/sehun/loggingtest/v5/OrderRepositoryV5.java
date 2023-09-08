package com.sehun.loggingtest.v5;

import com.sehun.loggingtest.trace.TraceStatus;
import com.sehun.loggingtest.trace.callback.TraceTemplate;
import com.sehun.loggingtest.trace.logtrace.LogTrace;
import com.sehun.loggingtest.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//@RequiredArgsConstructor
@Repository
public class OrderRepositoryV5 {
    private final TraceTemplate template;

    @Autowired
    public OrderRepositoryV5(LogTrace logTrace) {
        this.template = new TraceTemplate(logTrace);
    }



    public void save(String itemId){

        template.excute("repository.request",()-> {
            if (itemId.equals("ex")) {
                throw new IllegalArgumentException("throw exceptoin");
            }
            sleep(2000);
            return null;
        });

                }

    private void sleep(int mile) {
        try {
            Thread.sleep(mile);
        }catch (InterruptedException e){
            throw new IllegalArgumentException();
        }
    }
    }
//        TraceStatus status = null;
//
//        AbstractTemplate<Void> template = new AbstractTemplate<Void>(logTrace) {
//            @Override
//            protected Void call() {
//
//                if(itemId.equals("ex")){
//                    throw new IllegalArgumentException("throw exception");
//                }
//                sleep(2000);
//
//                return null;
//            }

//
//
//
//    private void sleep(int mile) {
//        try {
//            Thread.sleep(mile);
//        }catch (InterruptedException e){
//            throw new IllegalArgumentException();
//        }
//    }
//
//    ;








