package com.openclassrooms.tajmahal.ui.restaurant;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.openclassrooms.tajmahal.R;
import com.openclassrooms.tajmahal.data.repository.RestaurantRepository;
import com.openclassrooms.tajmahal.domain.model.Restaurant;
import com.openclassrooms.tajmahal.domain.model.Review;

import javax.inject.Inject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import dagger.hilt.android.lifecycle.HiltViewModel;

/**
 * MainViewModel is responsible for preparing and managing the data for the {@link DetailsFragment}.
 * It communicates with the {@link RestaurantRepository} to fetch restaurant details and provides
 * utility methods related to the restaurant UI.
 * <p>
 * This ViewModel is integrated with Hilt for dependency injection.
 */
@HiltViewModel
public class DetailsViewModel extends ViewModel {

    private final RestaurantRepository restaurantRepository;

    /**
     * Constructor that Hilt will use to create an instance of MainViewModel.
     *
     * @param restaurantRepository The repository which will provide restaurant data.
     */
    @Inject
    public DetailsViewModel(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    /**
     * Fetches the details of the Taj Mahal restaurant.
     *
     * @return LiveData object containing the details of the Taj Mahal restaurant.
     */
    public LiveData<Restaurant> getTajMahalRestaurant() {
        return restaurantRepository.getRestaurant();
    }

    public LiveData<List<Review>> getReviews() {
        return restaurantRepository.getReviews();
    }




    public int getNumberOfVotes(List<Review> reviews) {
        int numberVote = reviews.size();
        return numberVote;
    }


    public int getTotalRating(List<Review> reviews) {
        int totalRating = 0;
        for (Review review : reviews) {
            totalRating += review.getRate();
        }
        return totalRating;
    }


    public double getAverageNote(List<Review> reviews) {
        double totalRating = getTotalRating(reviews);


        double numberOfVotes = getNumberOfVotes(reviews);
        double averageRate;

        if (numberOfVotes > 0) {
            averageRate = totalRating / numberOfVotes;
            return averageRate;
        } else {
            return 0.0;
        }
    }

    public int getAverageProgressBar(List<Review> reviews, int starRating) {
        List<Review> starReviews = new ArrayList<>();
        int totalVotes = getNumberOfVotes(reviews);

        for (Review review : reviews) {
            if (review.getRate() == starRating) {
                starReviews.add(review);
            }
        }

        return (int) ((double) starReviews.size() / totalVotes * 100);
    }


    /**
     * Retrieves the current day of the week in French.
     *
     * @return A string representing the current day of the week in French.
     */
    public String getCurrentDay(Context context) {
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        String dayString;

        switch (dayOfWeek) {
            case Calendar.MONDAY:
                dayString = context.getString(R.string.monday);
                break;
            case Calendar.TUESDAY:
                dayString = context.getString(R.string.tuesday);
                break;
            case Calendar.WEDNESDAY:
                dayString = context.getString(R.string.wednesday);
                break;
            case Calendar.THURSDAY:
                dayString = context.getString(R.string.thursday);
                break;
            case Calendar.FRIDAY:
                dayString = context.getString(R.string.friday);
                break;
            case Calendar.SATURDAY:
                dayString = context.getString(R.string.saturday);
                break;
            case Calendar.SUNDAY:
                dayString = context.getString(R.string.sunday);
                break;
            default:
                dayString = "";
        }
        return dayString;
    }
}



