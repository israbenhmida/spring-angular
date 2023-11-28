package com.example.projet.Controller;

import com.example.projet.Entities.Chambre;
import com.example.projet.Entities.Restaurant;
import com.example.projet.Services.ChambreImp;
import com.example.projet.Services.RestaurantImp;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/restaurant")
@CrossOrigin(origins = "http://localhost:4200")

public class RestaurantController {
    private final RestaurantImp restaurantImp;


    @GetMapping
    public List<Restaurant> getAll() {
        return restaurantImp.getAll();
    }

    @GetMapping("/{idRestaurant}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable Long id) {
        Optional<Restaurant> restaurant = (Optional<Restaurant>) restaurantImp.getRestaurantById(id);
        return restaurant.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/ajoutRes")
    public ResponseEntity<Restaurant> saveRestaurant(@RequestBody Restaurant restaurant) {
        restaurantImp.saveRestaurant(restaurant);
        return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable("id") Long id, @RequestBody Restaurant restaurant) {
        restaurantImp.updateRestaurant(id, restaurant);
        return new ResponseEntity<Restaurant>(restaurant, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable Long id) {
        try {
            restaurantImp.deleteRestaurant(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
