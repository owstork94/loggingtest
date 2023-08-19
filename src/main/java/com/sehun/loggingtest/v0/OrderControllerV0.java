package com.sehun.loggingtest.v0;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV0 {

    private final OrderServiceV0 orderServiceV0;

    @GetMapping("v0/request")
    public String request(@RequestParam String itemId){
        orderServiceV0.orderItem(itemId);
    return "OK";
    }
}
