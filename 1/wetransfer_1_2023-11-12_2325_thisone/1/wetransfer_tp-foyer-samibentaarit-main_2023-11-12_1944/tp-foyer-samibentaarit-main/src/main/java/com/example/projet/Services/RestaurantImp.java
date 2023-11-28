package com.example.projet.Services;

import com.example.projet.Entities.Restaurant;
import com.example.projet.Entities.Universite;
import com.example.projet.Interfaces.IRestaurant;
import com.example.projet.Repositories.RestaurantRepository;
import com.example.projet.Repositories.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantImp implements IRestaurant {

    @Autowired
     private RestaurantRepository restaurantRepository;

    @Override
    public List<Restaurant> getAll() {
        return restaurantRepository.findAll();
    }

    @Override
    public Object getRestaurantById(Long idRestaurant) {
        return null;
    }


    @Override
    public void saveRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

    @Override
    public void updateRestaurant(Long idRes, Restaurant restaurant) {
        Restaurant existingrestaurant = restaurantRepository.findById(idRes).orElse(null);

        if (existingrestaurant != null) {
            existingrestaurant.setIdRestaurant(restaurant.getIdRestaurant());
            existingrestaurant.setNomRestaurant(restaurant.getNomRestaurant());
            existingrestaurant.setReservations(restaurant.getReservations());

           restaurantRepository.save(existingrestaurant);
        } else {
            throw new IllegalArgumentException("Restaurant with ID " + idRes + " does not exist.");
        }

    }

    @Override
    public void deleteRestaurant(Long idRes) {
        Restaurant restaurant = restaurantRepository.findById(idRes).orElse(null);

        if (restaurant != null) {
            restaurantRepository.delete(restaurant);
        } else {
            throw new IllegalArgumentException("restaurant with ID " + idRes + " does not exist.");
        }
    }

    }

