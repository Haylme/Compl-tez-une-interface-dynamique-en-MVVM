package com.openclassrooms.tajmahal.data.service;

import android.net.Uri;
import android.util.Log;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;
import com.openclassrooms.tajmahal.R;
import com.openclassrooms.tajmahal.databinding.FragmentReviewsListBinding;
import com.openclassrooms.tajmahal.domain.model.Restaurant;
import com.openclassrooms.tajmahal.domain.model.Review;

import java.util.Arrays;
import java.util.List;


/**
 * A mock implementation of the {@link RestaurantApi} for testing and development purposes.
 * <p>
 * This class simulates an API by returning a hard-coded {@link Restaurant} object, eliminating the
 * need for real network or database calls. Such fake or mock implementations are commonly used in
 * unit testing and when prototyping an application.
 * </p>
 * <p>
 * For beginners: In software development, a mock is a simulated version of an external system
 * (like an API). Mocks are used to isolate and test certain parts of the software without
 * depending on external systems. By using a mock, developers can simulate how the real system
 * would behave. In this case, instead of making a real API call to get restaurant details,
 * we are using hardcoded values.
 *
 * <p>
 * This class returns details of a specific restaurant, "Taj Mahal", with pre-defined attributes.
 * </p>
 *
 * @see Restaurant
 * @see RestaurantApi
 */
public class RestaurantFakeApi implements RestaurantApi {


    FragmentReviewsListBinding binding;


    /**
     * private boolean isClicked = false;
     * <p>
     * public boolean setupButtonClickListener() {
     * if (binding != null) {
     * binding.validateButton.setOnClickListener(new View.OnClickListener() {
     *
     * @Override public void onClick(View v) {
     * wasButtonClicked() = true;
     * }
     * });
     * }
     * return true;
     * }
     * <p>
     * <p>
     * public boolean wasButtonClicked() {
     * return isClicked;
     * }
     **/


    public boolean updateList() {


        String username = binding.namePost.getText().toString();

        Log.d("test", username);

        if (username.isEmpty()) {
            Snackbar.make(binding.getRoot(), "Name is needed", Snackbar.LENGTH_SHORT).setAnchorView(R.id.validate_Button).show();
            return false;
        }

        int rate = (int) binding.etoilesPost.getRating();

        if (rate < 1) {
            Snackbar.make(binding.getRoot(), "Select a valid rate value", Snackbar.LENGTH_SHORT).setAnchorView(R.id.validate_Button).show();
            return false;
        }

        String comment = binding.textedit.getText().toString();

        if (comment.isEmpty()) {
            Snackbar.make(binding.getRoot(), "Review is needed", Snackbar.LENGTH_SHORT).setAnchorView(R.id.validate_Button).show();
            return false;
        }


        String picture = Uri.parse("android.resource://com.openclassrooms.tajmahal/" + R.drawable.avatarpost).toString();

        reviews.add(new Review(username, picture, comment, rate));
        return true;

    }


    List<Review> reviews = Arrays.asList(


            new Review("Ranjit Singh", "https://xsgames.co/randomusers/assets/avatars/male/71.jpg", "Service très rapide et nourriture délicieuse, nous mangeons ici chaque week-end, c'est très rapide et savoureux. Continuez ainsi!", 5),
            new Review("Martyna Siddeswara", "https://xsgames.co/randomusers/assets/avatars/female/31.jpg", "Un service excellent et des plats incroyablement savoureux. Nous sommes vraiment satisfaits de notre expérience au restaurant.", 4),
            new Review("Komala Alanazi", "https://xsgames.co/randomusers/assets/avatars/male/46.jpg", "La cuisine est délicieuse et le service est également excellent. Le propriétaire est très sympathique et veille toujours à ce que votre repas soit satisfaisant. Cet endroit est un choix sûr!", 5),
            new Review("David John", "https://xsgames.co/randomusers/assets/avatars/male/67.jpg", "Les currys manquaient de diversité de saveurs et semblaient tous à base de tomates. Malgré les évaluations élevées que nous avons vues et nos attentes, nous avons été déçus.", 2),
            new Review("Emilie Hood", "https://xsgames.co/randomusers/assets/avatars/female/20.jpg", "Très bon restaurant Indien ! Je recommande.", 4)
    );


    /**
     * Retrieves a hard-coded {@link Restaurant} object for the "Taj Mahal".
     * <p>
     * This method simulates an API call by immediately returning a Restaurant object
     * with pre-defined attributes. The object represents the "Taj Mahal" restaurant
     * with specific details.
     * </p>
     *
     * @return The hard-coded {@link Restaurant} object for the "Taj Mahal".
     */
    @Override
    public Restaurant getRestaurant() {
        return new Restaurant("Taj Mahal", "Indien", "11h30 - 14h30・18h30 - 22h00",
                "12 Avenue de la Brique - 75010 Paris", "http://www.tajmahal.fr", "06 12 34 56 78",
                true, true);
    }


    public List<Review> newRefresh(List<Review> reviews) {
        // this.reviews.clear();
        this.reviews.addAll(reviews);
        notifyAll();


        return reviews;
    }


    public void newlistUpdate() {

        binding.validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (updateList()) {

                    getReviews() = new Review(reviews) {


                        
                    }
                }
            }
        });


    }


    @Override
    public List<Review> getReviews() {

        return reviews;

    }
}



