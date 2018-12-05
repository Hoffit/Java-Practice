import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ShopTest {

    @Test public void testToStringMethod() {
        Shop shop = new Shop("Portage Glacier Lodge Gift Shop", "Lodge shop with local tourist items", 2);
        Review review = new Review("Great selection of unique items!", "Hull", 3);
        shop.addReview(review);
        String toStringResult = shop.toString();
        String expected = "name Portage Glacier Lodge Gift Shop, description Lodge shop with local tourist items, rating 3.0, priceLevel 2 [review Great selection of unique items!, author Hull, rating 3.0]";
        assertTrue(toStringResult.equals(expected));
    }

    @Test public void testAddReviewMethod_Basic() {
        Shop shop = new Shop("Portage Glacier Lodge Gift Shop", "Lodge shop with local tourist items", 2);
        Review review = new Review("Great selection of unique items!", "Hull", 3);
        shop.addReview(review);
        assertTrue(shop.getRating() == 3.0);
    }

    @Test public void testAddReviewMethod_DuplicateReview() {
        Shop shop = new Shop("Portage Glacier Lodge Gift Shop", "Lodge shop with local tourist items", 2);
        Review review = new Review("Great selection of unique items!", "Hull", 3);
        shop.addReview(review);
        shop.addReview(review);
        assertTrue(shop.getReviews().size() == 1);
    }

    @Test public void testAddReviewMethod_AverageRounding() {
        Shop shop = new Shop("Portage Glacier Lodge Gift Shop", "Lodge shop with local tourist items", 2);
        Review review1 = new Review("Great selection of unique items!", "Hull", 3);
        Review review2 = new Review("Cool hats!", "Johnson", 4);
        Review review3 = new Review("Big selection of shot glasses.", "Parker", 3);
        shop.addReview(review1);
        shop.addReview(review2);
        shop.addReview(review3);
        assertTrue(shop.getRating() == 3.3);
    }
}
