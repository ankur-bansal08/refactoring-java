import java.util.Objects;

/**
 * Represents a rental of a movie.
 */
public class MovieRental {
    private final int days;
    private final Movie movie;

    /**
     * Constructs a MovieRental with the given movie ID and rental duration in days.
     *
     * @param movie The ID of the rented movie.
     * @param days  The duration of the rental in days.
     * @throws NullPointerException if the movie ID is null.
     */
    public MovieRental(Movie movie, int days) {
        this.movie = Objects.requireNonNull(movie, "Movie cannot be null.");
        if (days < 1)
            throw new IllegalArgumentException("Number of rental days has to be at least 1");

        this.days = days;
    }

    /**
     * Gets the Object of the rented movie.
     *
     * @return The movie Object.
     */
    public Movie getMovie() {
        return movie;
    }

    /**
     * Gets the duration of the rental in days.
     *
     * @return The number of days for which the movie is rented.
     */
    public int getDays() {
        return days;
    }


    /**
     * Calculates the rental amount for this movie rental.
     *
     * @return The rental amount.
     */
    public double getRentalAmount() {
        return movie.calculateRent(days);
    }

    /**
     * Calculates the frequent enter points earned for this movie rental.
     *
     * @return The frequent enter points earned.
     */
    public int getFrequentEnterPoints() {
        return movie.calculateFrequentEnterPoints(days);
    }

}
