package dev.techsphere.restaurant.controller;

import dev.techsphere.restaurant.model.Restaurant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestaurantController {

    @GetMapping("/get-restaurant-list")
    public ResponseEntity<?> getRestaurantList() {
        return new ResponseEntity<>("{\n" +
                "    \"restaurants\": [\n" +
                "        {\n" +
                "            \"restaurantId\": 1,\n" +
                "            \"restaurantName:\": \"Restaurant 1\" \n" +
                "        },\n" +
                "        {\n" +
                "            \"restaurantId\": 2,\n" +
                "            \"restaurantName:\": \"Restaurant 2\" \n" +
                "        },\n" +
                "        {\n" +
                "            \"restaurantId\": 3,\n" +
                "            \"restaurantName:\": \"Restaurant 3\" \n" +
                "        },\n" +
                "        {\n" +
                "            \"restaurantId\": 4,\n" +
                "            \"restaurantName:\": \"Restaurant 4\" \n" +
                "        },\n" +
                "        {\n" +
                "            \"restaurantId\": 5,\n" +
                "            \"restaurantName:\": \"Restaurant 5\" \n" +
                "        }\n" +
                "    ]\n" +
                "}", HttpStatus.OK);
    }

    @PostMapping("/register-new-restaurant")
    public ResponseEntity<?> registerNewRestaurant(@RequestBody Restaurant restaurant) {
        return new ResponseEntity<>("Your restaurant is successfully registered!", HttpStatus.OK);
    }
}
