package dev.techsphere.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/user-profile/{userId}")
    public ResponseEntity<?> getProfileDetails(@PathVariable String userId) {
        return new ResponseEntity<>("{\n" +
                "    \"userId\": 1,\n" +
                "    \"name\": \"Johnnathan\",\n" +
                "    \"age\": 30,\n" +
                "    \"email\": \"johnnathan@mail.com\",\n" +
                "    \"mbNo\": 9876543210\n" +
                "}", HttpStatus.OK);
    }

    @GetMapping("/user-order-history/{userId}")
    public ResponseEntity<?> getUserOrderHistory(@PathVariable String userId) {
        String resp = restTemplate.getForObject("http://localhost:8085/order/api/get-order-list/1", String.class);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
}
