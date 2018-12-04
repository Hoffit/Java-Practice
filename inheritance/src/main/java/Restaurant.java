import java.util.ArrayList;

public class Restaurant {

    private String name;
    private double rating = 0; // such as 1-5
    private int priceLevel; // such as 1-5
    private ArrayList<Review> reviews;

    public Restaurant(String name, int priceLevel) {
        this.name = name;
        this.priceLevel = priceLevel;
        this.reviews = new ArrayList<Review>();
    }

    public String toString() {
        String returnString = "name " + name + ", rating " + rating + ", priceLevel " + priceLevel;
        for (int i=0; i<reviews.size(); i++) {
            returnString += " [" + reviews.get(i).toString() + "]";
        }
        return returnString;
    }

    public void addReview(Review newReview) {
        if (!reviews.contains(newReview)) {
            reviews.add(newReview);
            calculateAverageRating();
        }
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    private void calculateAverageRating() {
        double totalRating = 0;
        for (Review aReview: reviews) {
            totalRating += aReview.getRating();
        }
        int temp = (int) ( (totalRating / reviews.size()) * 10 );
        rating = (double)temp / 10.0;
    }

    public double getRating() {
        return rating;
    }
}
