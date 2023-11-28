package com.example.projet.Interfaces;

import com.example.projet.Entities.Restaurant;
import com.example.projet.Entities.Universite;

import java.util.List;

public interface IRestaurant {
    List<Restaurant> getAll();
    Object getRestaurantById(Long idRestaurant);
    void saveRestaurant(Restaurant restaurant);
    void updateRestaurant(Long idRestaurant, Restaurant restaurant);
    void deleteRestaurant(Long idRestaurant);

}
