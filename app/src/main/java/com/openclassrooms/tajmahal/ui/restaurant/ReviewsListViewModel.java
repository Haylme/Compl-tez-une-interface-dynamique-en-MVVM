package com.openclassrooms.tajmahal.ui.restaurant;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.openclassrooms.tajmahal.data.repository.RestaurantRepository;
import com.openclassrooms.tajmahal.domain.model.Review;

import java.util.List;

public class ReviewsListViewModel extends ViewModel {


    private RestaurantRepository repository;


    public ReviewsListViewModel (RestaurantRepository repository){
        this.repository = repository;
    }






    public LiveData<List<Review>> getReviews() {
        return repository.getReviews();
    }




}