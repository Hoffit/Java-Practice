import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TheaterTest {

    @Test public void testToStringMethod() {
        Theater theater = new Theater("Regal Tikahtnu Stadium 16 IMAX & RPX");
        Review review = new Review("Best theater in Alaska!", "Hull", 3);
        theater.addReview(review);
        String toStringResult = theater.toString();
        String expected = "name Regal Tikahtnu Stadium 16 IMAX & RPX, rating 3.0 [review Best theater in Alaska!, author Hull, rating 3.0]";
        assertTrue(toStringResult.equals(expected));
    }

    @Test public void testAddReviewMethod_Basic() {
        Theater theater = new Theater("Regal Tikahtnu Stadium 16 IMAX & RPX");
        Review review = new Review("Best theater in Alaska!", "Hull", 3);
        theater.addReview(review);
        assertTrue(theater.getRating() == 3.0);
    }

    @Test public void testAddReviewMethod_DuplicateReview() {
        Theater theater = new Theater("Regal Tikahtnu Stadium 16 IMAX & RPX");
        Review review = new Review("Best theater in Alaska!", "Hull", 3);
        theater.addReview(review);
        theater.addReview(review);
        assertTrue(theater.getReviews().size() == 1);
    }

    @Test public void testAddReviewMethod_AverageRounding() {
        Theater theater = new Theater("Regal Tikahtnu Stadium 16 IMAX & RPX");
        Review review1 = new Review("Best theater in Alaska!", "Hull", 3);
        Review review2 = new Review("Comfy Seats!", "Johnson", 4);
        Review review3 = new Review("Awesome popcorn!", "Parker", 3);
        theater.addReview(review1);
        theater.addReview(review2);
        theater.addReview(review3);
        assertTrue(theater.getRating() == 3.3);
    }

    @Test public void testAddMovieMethod() {
        Theater theater = new Theater("Regal Tikahtnu Stadium 16 IMAX & RPX");
        String movieTitle1 = "Shrek";
        String movieTitle2 = "Shrek 2";
        String movieTitle3 = "Shrek 3";
        theater.addMovie(movieTitle1);
        theater.addMovie(movieTitle2);
        theater.addMovie(movieTitle3);
        assertTrue(theater.getMovies().contains(movieTitle1));
        assertTrue(theater.getMovies().contains(movieTitle2));
        assertTrue(theater.getMovies().contains(movieTitle3));
    }

    @Test public void testRemoveMovieMethod() {
        Theater theater = new Theater("Regal Tikahtnu Stadium 16 IMAX & RPX");
        String movieTitle1 = "Shrek";
        theater.addMovie(movieTitle1);
        assertTrue(theater.getMovies().contains(movieTitle1));
        theater.removeMovie(movieTitle1);
        assertTrue(!theater.getMovies().contains(movieTitle1));
    }

    @Test public void testToStringMethod_MovieReview() {
        Theater theater = new Theater("Regal Tikahtnu Stadium 16 IMAX & RPX");
        MovieReview review = new MovieReview("Best theater in Alaska!", "Hull", 3, "Shrek");
        theater.addReview(review);
        String toStringResult = theater.toString();
        String expected = "name Regal Tikahtnu Stadium 16 IMAX & RPX, rating 3.0 [review Best theater in Alaska!, author Hull, rating 3.0, movie Shrek]";
        assertTrue(toStringResult.equals(expected));
    }

    @Test public void testToStringMethod_MovieReviewPlusMovies() {
        Theater theater = new Theater("Regal Tikahtnu Stadium 16 IMAX & RPX", new String[] {"Shrek", "Shrek 2", "Shrek 3"});
        MovieReview review = new MovieReview("Best theater in Alaska!", "Hull", 3, "Shrek");
        theater.addReview(review);
        String toStringResult = theater.toString();
        String expected = "name Regal Tikahtnu Stadium 16 IMAX & RPX, rating 3.0 [Shrek], [Shrek 2], [Shrek 3] [review Best theater in Alaska!, author Hull, rating 3.0, movie Shrek]";
        assertTrue(toStringResult.equals(expected));
    }

    @Test public void testAddMovieReview() {
        Theater theater = new Theater("Regal Tikahtnu Stadium 16 IMAX & RPX", new String[] {"Shrek", "Shrek 2", "Shrek 3"});
        MovieReview review = new MovieReview("Best theater in Alaska!", "Hull", 3, "Shrek");
        theater.addReview(review);
        assertTrue(theater.getReviews().contains(review));
    }
}
