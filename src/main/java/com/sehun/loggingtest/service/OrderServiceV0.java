package com.sehun.loggingtest.service;

import com.sehun.loggingtest.repository.OrderRepositoryV0;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceV0 {
    private OrderRepositoryV0 orderRepositoryV0;


    public OrderServiceV0(OrderRepositoryV0 orderRepositoryV0) {
        this.orderRepositoryV0 = orderRepositoryV0;
    }

    public void orderItem(String itemId) throws InterruptedException {
        orderRepositoryV0.save(itemId);
    }


}
