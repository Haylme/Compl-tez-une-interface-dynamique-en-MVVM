package com.openclassrooms.tajmahal.ui.restaurant;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import javax.inject.Inject;
import com.openclassrooms.tajmahal.data.repository.RestaurantRepository;
import com.openclassrooms.tajmahal.domain.model.Review;

import java.util.List;
import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class ReviewsListViewModel extends ViewModel {


    private final RestaurantRepository repository;


   @Inject
   public ReviewsListViewModel (RestaurantRepository repository){
       this.repository = repository;
   }






    public LiveData<List<Review>> getReviews() {
        return repository.getReviews();
    }












}