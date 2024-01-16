package com.openclassrooms.tajmahal.ui.restaurant;

import androidx.lifecycle.ViewModel;

import com.openclassrooms.tajmahal.data.repository.RestaurantRepository;

public class ReviewsListViewModel extends ViewModel {


    private RestaurantRepository repository;


    ReviewsListViewModel (RestaurantRepository repository){
        this.repository = repository;
    }


    public void getReviews() {
        repository.getReviews();
    }

}