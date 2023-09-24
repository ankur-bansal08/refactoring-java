import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Represents a movie in a rental system.
 */
public abstract class Movie {

    private final String id; // The unique ID of the movie.
    private final String title; // The title of the movie.
    private String movieCategoryType; // The category code of the movie.
    private static final Map<String, Movie> movieMap; // A map to store movies by their IDs.

    static {
        movieMap = new HashMap<>();
        movieMap.put("F001", MovieFactory.getMovie(MovieCategoryType.REGULAR, "F001", "You've Got Mail"));
        movieMap.put("F002", MovieFactory.getMovie(MovieCategoryType.REGULAR, "F002", "Matrix"));
        movieMap.put("F003", MovieFactory.getMovie(MovieCategoryType.CHILDREN, "F003", "Cars"));
        movieMap.put("F004", MovieFactory.getMovie(MovieCategoryType.NEW, "F004", "Fast & Furious X"));
    }

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
     * Gets the category code of the movie.
     *
     * @return The movie's category code.
     */
    public String getMovieCategoryType() {
        return movieCategoryType;
    }

    /**
     * Gets a movie by its ID.
     *
     * @param movieId The ID of the movie to retrieve.
     * @return The movie object with the specified ID.
     * @throws MovieNotFoundException If the requested movie is not found.
     */
    public static Movie getMovie(String movieId) {
        Movie movie = movieMap.getOrDefault(movieId, null);
        if (Objects.isNull(movie))
            throw new MovieNotFoundException("Requested Movie Not found.");
        return movie;
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
