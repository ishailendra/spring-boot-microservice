package dev.techsphere.order.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/api")
public class OrderController {

    @GetMapping("/get-order-list/{userId}")
    public ResponseEntity<?> getOrderList(@PathVariable String userId) {

        String resp = "";

        if ("1".equals(userId)) {
            resp = "{\n" +
                    "    \"userId\": 1,\n" +
                    "    \"orderId\": 123123,\n" +
                    "    \"foodName\": \"Samosa\"\n" +
                    "}";
        } else if ("2".equals(userId)) {
            resp = "{\n" +
                    "    \"userId\": 2,\n" +
                    "    \"orderId\": 233123,\n" +
                    "    \"foodName\": \"Noodles\"\n" +
                    "}";
        }

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @PostMapping("/cancel-order/{userId}")
    public ResponseEntity<?>  cancelOrder(@PathVariable String userId) {
        return new ResponseEntity<>("Your order: " + new Random().nextInt() + " is cancelled.", HttpStatus.OK);
    }
}
