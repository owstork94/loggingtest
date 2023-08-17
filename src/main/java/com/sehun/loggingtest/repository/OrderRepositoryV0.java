package com.sehun.loggingtest.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static java.lang.Thread.sleep;
@RequiredArgsConstructor
@Repository
public class OrderRepositoryV0 {

    public void save(String itemId) throws InterruptedException {
        if (itemId.equals("ex")){
            throw new IllegalArgumentException("FF");
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

