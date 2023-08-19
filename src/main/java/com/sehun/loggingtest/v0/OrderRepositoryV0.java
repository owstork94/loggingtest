package com.sehun.loggingtest.v0;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
@RequiredArgsConstructor
@Repository
public class OrderRepositoryV0 {

    public void save(String itemId){
        if (itemId.equals("ex")){
            throw new IllegalArgumentException("throw exception");
        }
        sleep(1000);
    }

    public void sleep(int mile){
        try {
            Thread.sleep(mile);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}

