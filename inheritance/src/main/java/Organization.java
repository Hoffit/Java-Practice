import java.util.ArrayList;

// TODO: consider design tweak
// Design note: priceLevel is not required for Theater. So, having it built into this class such that all instances have it,
// is sub-optimal. There are some design alternatives. But - leave it - it's just a bloody int.

public abstract class Organization {

    private ArrayList<Review> reviews;
    private String name;
    private double rating = 0; // such as 1-5
    private int priceLevel; // such as 1-5

    public Organization(String name) {
        this.name = name;
        this.reviews = new ArrayList<Review>();
    }

    public Organization(String name, int priceLevel) {
        this.name = name;
        this.priceLevel = priceLevel;
        this.reviews = new ArrayList<Review>();
    }

    public void addReview(Review newReview) {
        if (!reviews.contains(newReview)) {
            reviews.add(newReview);
            calculateAverageRating();
        }
    }

    private void calculateAverageRating() {
        double totalRating = 0;
        for (Review aReview: reviews) {
            totalRating += aReview.getRating();
        }
        int temp = (int) ( (totalRating / reviews.size()) * 10 );
        rating = (double)temp / 10.0;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public double getRating() {
        return rating;
    }

    public String toString() {
        String returnString = "name " + name + ", rating " + rating + ", priceLevel " + priceLevel;
        for (int i=0; i<reviews.size(); i++) {
            returnString += " [" + reviews.get(i).toString() + "]";
        }
        return returnString;
    }

    public String getName() {
        return name;
    }

    public int getPriceLevel() {
        return priceLevel;
    }
}
