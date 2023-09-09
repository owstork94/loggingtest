package com.sehun.loggingtest.v4;

import com.sehun.loggingtest.trace.TraceStatus;
import com.sehun.loggingtest.trace.logtrace.LogTrace;
import com.sehun.loggingtest.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
@RequiredArgsConstructor
@Repository
public class OrderRepositoryV4 {

    private final LogTrace logTrace;

    public Void save(String itemId){
        TraceStatus status = null;

        AbstractTemplate<Void> template = new AbstractTemplate<Void>(logTrace) {
            @Override
            protected Void call() {

                if(itemId.equals("ex")){
                    throw new IllegalArgumentException("throw exception");
                }
                sleep(2000);

                return null;
            }

            private void sleep(int mile) {

                    try {
                        Thread.sleep(mile);
                    }catch (InterruptedException e){
                        throw new IllegalArgumentException();
                    }

            }

            };
        return template.excute("OrderRepository.save()");
        };







}

