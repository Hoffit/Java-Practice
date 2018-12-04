import org.junit.Test;

import static org.junit.Assert.*;

public class ReviewTest {

    @Test public void testToStringMethod() {
        Review review = new Review("Great clam chowder!", "David", 3);
        String toStringResult = review.toString();
        String expected = "review Great clam chowder!, author David, rating 3.0";
        assertTrue(toStringResult.equals(expected));
    }
}
