import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RestaurantTest {

    @Test public void testToStringMethod() {
        Restaurant restaurant = new Restaurant("Portage Glacier Lodge", 2);
        Review review = new Review("Great clam chowder!", "Hull", 3);
        restaurant.addReview(review);
        String toStringResult = restaurant.toString();
        String expected = "name Portage Glacier Lodge, rating 3.0, priceLevel 2 [review Great clam chowder!, author Hull, rating 3.0]";
        assertTrue(toStringResult.equals(expected));
    }

    @Test public void testAddReviewMethod_Basic() {
        Restaurant restaurant = new Restaurant("Portage Glacier Lodge", 2);
        Review review = new Review("Great clam chowder!", "Hull", 3);
        restaurant.addReview(review);
        assertTrue(restaurant.getRating() == 3.0);
    }

    @Test public void testAddReviewMethod_DuplicateReview() {
        Restaurant restaurant = new Restaurant("Portage Glacier Lodge", 2);
        Review review = new Review("Great clam chowder!", "Hull", 3);
        restaurant.addReview(review);
        restaurant.addReview(review);
        assertTrue(restaurant.getReviews().size() == 1);
    }

    @Test public void testAddReviewMethod_AverageRounding() {
        Restaurant restaurant = new Restaurant("Portage Glacier Lodge", 2);
        Review review1 = new Review("Great clam chowder!", "Hull", 3);
        Review review2 = new Review("Love the ham sandwhich!", "Johnson", 4);
        Review review3 = new Review("Lovely service!", "Parker", 3);
        restaurant.addReview(review1);
        restaurant.addReview(review2);
        restaurant.addReview(review3);
        assertTrue(restaurant.getRating() == 3.3);
    }
}
