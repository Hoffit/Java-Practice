public class MovieReview extends Review {

    private String movie;

    public MovieReview(String review, String author, double rating, String aMovie) {
        super(review, author, rating);
        this.movie = aMovie;
    }

    public String toString() {
        return "review " + getReview() + ", author " + getAuthor() + ", rating " + getRating() + ", movie " + movie;
    }
}
