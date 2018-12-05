public class Shop extends Organization {

    private String description;

    public Shop(String name, String description, int priceLevel) {
        super(name, priceLevel);
        this.description = description;
    }

    public String toString() {
        String returnString = "name " + getName() + ", description " + description + ", rating " + getRating() + ", priceLevel " + getPriceLevel();
        for (int i=0; i<getReviews().size(); i++) {
            returnString += " [" + getReviews().get(i).toString() + "]";
        }
        return returnString;
    }
}
