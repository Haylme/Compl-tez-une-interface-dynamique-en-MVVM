package com.openclassrooms.tajmahal.ui.restaurant;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

import com.openclassrooms.tajmahal.data.repository.RestaurantRepository;
import com.openclassrooms.tajmahal.domain.model.Review;

import java.util.List;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class ReviewsListViewModel extends ViewModel {


    private LiveData<List<Review>> reviewsLiveData;

    private final RestaurantRepository repository;


    @Inject
    public ReviewsListViewModel(RestaurantRepository repository) {
        this.repository = repository;

    }


    public LiveData<List<Review>> getReviews() {
        if (reviewsLiveData == null) {
            reviewsLiveData = repository.getReviews();

        }
        return reviewsLiveData;
    }


    public void addReview(Review review) {
        repository.addReview(review);


    }





}
