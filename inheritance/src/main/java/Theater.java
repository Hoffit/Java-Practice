import java.util.ArrayList;

public class Theater extends Organization {

    private ArrayList<String> movies;

    public Theater(String name) {
        super(name);
        this.movies = new ArrayList<String>();
    }

    public Theater(String name, String[] movies) {
        super(name);
        this.movies = new ArrayList<String>();
        for (int i = 0; i < movies.length; i++) {
            this.movies.add(movies[i]);
        }
    }

    public String toString() {
        String returnString = "name " + getName() + ", rating " + getRating();
        for (int i = 0; i < getMovies().size(); i++) {
            returnString += " [" + getMovies().get(i).toString() + "]";
            if ((i + 1) < getMovies().size()) {
                returnString += ",";
            }
        }
        for (int i = 0; i < getReviews().size(); i++) {
            returnString += " [" + getReviews().get(i).toString() + "]";
            if ((i + 1) < getReviews().size()) {
                returnString += ",";
            }
        }
        return returnString;
    }

    public ArrayList<String> getMovies() {
        return movies;
    }

    public void addMovie(String aMovie) {
        if (!movies.contains(aMovie)) {
            movies.add(aMovie);
        }
    }

    public void removeMovie(String aMovie) {
        movies.remove(aMovie);
    }
}
