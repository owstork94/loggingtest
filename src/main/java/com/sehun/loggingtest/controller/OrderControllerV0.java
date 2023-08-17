package com.sehun.loggingtest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.sehun.loggingtest.service.OrderServiceV0;

@RestController
public class OrderControllerV0 {

    private final OrderServiceV0 orderServiceV0;


    public OrderControllerV0(OrderServiceV0 orderServiceV0) {
        this.orderServiceV0 = orderServiceV0;
    }

    @GetMapping("v0/request")
    public String request(@RequestParam String itemId) throws InterruptedException {
        orderServiceV0.orderItem(itemId);
    return "OK";
    }
}
