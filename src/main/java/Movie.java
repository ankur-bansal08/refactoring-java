/**
 * Represents a movie in a rental system.
 */
public abstract class Movie {

    private final String id; // The unique ID of the movie.
    private final String title; // The title of the movie.


    public Movie(String id, String title) {
        this.id = id;
        this.title = title;
    }

    /**
     * Gets the ID of the movie.
     *
     * @return The movie's ID.
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the title of the movie.
     *
     * @return The movie's title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Calculates the rental amount for the movie based on the number of days rented.
     *
     * @param days The number of days the movie is rented.
     * @return The rental amount.
     */
    public abstract double calculateRent(int days);

    /**
     * Calculates the frequent enter points earned for renting the movie based on the number of days rented.
     *
     * @param days The number of days the movie is rented.
     * @return The frequent enter points earned.
     */
    public abstract int calculateFrequentEnterPoints(int days);
}
