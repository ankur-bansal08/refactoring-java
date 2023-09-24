import java.util.Objects;

/**
 * Represents a rental of a movie.
 */
public class MovieRental {
    private final int days;
    private final String movieId;
    private Movie movie = null;

    /**
     * Constructs a MovieRental with the given movie ID and rental duration in days.
     *
     * @param movieId The ID of the rented movie.
     * @param days    The duration of the rental in days.
     * @throws NullPointerException if the movie ID is null.
     */
    public MovieRental(String movieId, int days) {
        this.movieId = Objects.requireNonNull(movieId, "Movie ID cannot be null.");
        if (days < 1)
            throw new IllegalArgumentException("Number of rental days has to be at least 1");

        this.days = days;
    }

    /**
     * Gets the ID of the rented movie.
     *
     * @return The movie ID.
     */
    public String getMovieId() {
        return movieId;
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
     * Gets the rented movie.
     *
     * @return The rented movie.
     */
    public Movie getMovie() {
        if (Objects.isNull(this.movie))
            movie = Movie.getMovie(movieId);
        return movie;
    }

    /**
     * Calculates the rental amount for this movie rental.
     *
     * @return The rental amount.
     */
    public double getRentalAmount() {
        return getMovie().calculateRent(getDays());
    }

    /**
     * Calculates the frequent enter points earned for this movie rental.
     *
     * @return The frequent enter points earned.
     */
    public int getFrequentEnterPoints() {
        return getMovie().calculateFrequentEnterPoints(getDays());
    }

}
