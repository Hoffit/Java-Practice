public class Review {

    private String review;
    private String author;
    private double rating; // such as 1-5

    public Review(String review, String author, double rating) {
        this.review = review;
        this.author = author;
        this.rating = rating;

    }

    public String toString() {
        return "review " + review + ", author " + author + ", rating " + rating;
    }

    public double getRating() {
        return rating;
    }

    public String getReview() {
        return review;
    }

    public String getAuthor() {
        return author;
    }
}
