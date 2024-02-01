package com.openclassrooms.tajmahal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.openclassrooms.tajmahal.data.service.RestaurantFakeApi;
import com.openclassrooms.tajmahal.domain.model.Review;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class RestaurantfakeApiTest {


    RestaurantFakeApi restaurantFakeApi;




    @Before
    public void setUp() {
        restaurantFakeApi = new RestaurantFakeApi();
    }


    @Test
    public void getReviews_returnsInitialListOfReviews() {
        List<Review> reviews = restaurantFakeApi.getReviews();
        assertNotNull(reviews);
        assertFalse(reviews.isEmpty());

    }

    @Test
    public void addItem_addsNewReviewAtTheBeginningOfTheList() {
        Review newReview = new Review("New User", "https://example.com/avatar.jpg", "Great food!", 5);
        restaurantFakeApi.addItem(newReview);
        List<Review> reviews = restaurantFakeApi.getReviews();
        assertNotNull(reviews);
        assertFalse(reviews.isEmpty());
        assertEquals(newReview, reviews.get(0));
    }




    @Test
    public void addItemFillFieldTest() {
        Review testReview = new Review("new user", "https://example.com/avatar.jpg", "blabla", 5);
        restaurantFakeApi.addItem(testReview);

        assertFalse(testReview.getComment().isEmpty());

        assertFalse(testReview.getRate()<1);
    }


}
