package com.openclassrooms.tajmahal.data.service;

import com.openclassrooms.tajmahal.domain.model.Restaurant;
import com.openclassrooms.tajmahal.domain.model.Review;

import java.util.ArrayList;
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

    List<Review> reviews = Arrays.asList(


            new Review("Ranjit Singh", "https://xsgames.co/randomusers/assets/avatars/male/71.jpg", "Service très rapide et nourriture délicieuse, nous mangeons ici chaque week-end, c'est très rapide et savoureux. Continuez ainsi!", 5),
            new Review("Martyna Siddeswara", "https://xsgames.co/randomusers/assets/avatars/female/31.jpg", "Un service excellent et des plats incroyablement savoureux. Nous sommes vraiment satisfaits de notre expérience au restaurant.", 4),
            new Review("Komala Alanazi", "https://xsgames.co/randomusers/assets/avatars/male/46.jpg", "La cuisine est délicieuse et le service est également excellent. Le propriétaire est très sympathique et veille toujours à ce que votre repas soit satisfaisant. Cet endroit est un choix sûr!", 5),
            new Review("David John", "https://xsgames.co/randomusers/assets/avatars/male/67.jpg", "Les currys manquaient de diversité de saveurs et semblaient tous à base de tomates. Malgré les évaluations élevées que nous avons vues et nos attentes, nous avons été déçus.", 2),
            new Review("Emilie Hood", "https://xsgames.co/randomusers/assets/avatars/female/20.jpg", "Très bon restaurant Indien ! Je recommande.", 4)
    );


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


    public int getAverageProgressBar1(List<Review> reviews) {
        List<Review> oneStar = new ArrayList<>();
        int numberOfVotes1 = getNumberOfVotes(reviews);

        for (Review review : reviews) {
            if (review.getRate() == 1) {
                oneStar.add(review);
            }
        }

        return (int) ((double) oneStar.size() / numberOfVotes1 * 100);
    }


    public int getAverageProgressBar2(List<Review> reviews) {
        List<Review> twoStar = new ArrayList<>();
        int numberOfVotes2 = getNumberOfVotes(reviews);

        for (Review review : reviews) {
            if (review.getRate() == 2) {
                twoStar.add(review);
            }
        }

        return (int) ((double) twoStar.size() / numberOfVotes2 * 100);
    }


    public int getAverageProgressBar3(List<Review> reviews) {
        List<Review> threeStar = new ArrayList<>();
        int numberOfVotes3 = getNumberOfVotes(reviews);

        for (Review review : reviews) {
            if (review.getRate() == 3) {
                threeStar.add(review);
            }
        }

        return (int) ((double) threeStar.size() / numberOfVotes3 * 100);
    }


    public int getAverageProgressBar4(List<Review> reviews) {
        List<Review> fourStar = new ArrayList<>();
        int numberOfVotes4 =getNumberOfVotes(reviews);

        for (Review review : reviews) {
            if (review.getRate() == 4) {
                fourStar.add(review);
            }
        }

        return (int) ((double) fourStar.size() / numberOfVotes4 * 100);
    }

    public int getAverageProgressBar5(List<Review> reviews) {
        List<Review> fiveStar = new ArrayList<>();
        int numberOfVotes5 = getNumberOfVotes(reviews);

        for (Review review : reviews) {
            if (review.getRate() == 5) {
                fiveStar.add(review);
            }
        }

        return (int) ((double) fiveStar.size() / numberOfVotes5 * 100);
    }






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


    /**
     * Retrieves a hard-coded {@link Review} object for the "Taj Mahal".
     * <p>
     * This method simulates an API call by immediately returning a Review list
     * with pre-defined attributes.
     * </p>
     *
     * @return The hard-coded list {@link Review} for the "Taj Mahal".
     */
    @Override
    public List<Review> getReviews() {
        return reviews;
    }
}


