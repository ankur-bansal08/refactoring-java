import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * The {@code MovieFactory} class is responsible for creating movie objects based on the provided
 * {@code MovieCode} and other details such as ID and title.
 */
public class MovieFactory {

    private static final Map<String, Movie> movieMap; // A map to store movies by their IDs.

    static {
        movieMap = new HashMap<>();
        movieMap.put("F001", MovieFactory.getMovie(MovieCategoryType.REGULAR, "F001", "You've Got Mail"));
        movieMap.put("F002", MovieFactory.getMovie(MovieCategoryType.REGULAR, "F002", "Matrix"));
        movieMap.put("F003", MovieFactory.getMovie(MovieCategoryType.CHILDREN, "F003", "Cars"));
        movieMap.put("F004", MovieFactory.getMovie(MovieCategoryType.NEW, "F004", "Fast & Furious X"));
    }

    /**
     * Creates a new movie object based on the provided {@code MovieCode}, ID, and title.
     *
     * @param code  The {@code MovieCode} indicating the type of movie to create.
     * @param id    The ID of the movie.
     * @param title The title of the movie.
     * @return A movie object of the specified type.
     * @throws IllegalArgumentException If an invalid or unsupported {@code MovieCode} is provided.
     */
    public static Movie getMovie(MovieCategoryType code, String id, String title) {
        if (Objects.isNull(code))
            throw new IllegalArgumentException("No Movie Category Code provided.");
        return switch (code) {
            case REGULAR -> new RegularMovie(id, title);
            case CHILDREN -> new ChildrenMovie(id, title);
            case NEW -> new NewMovie(id, title);
            default -> throw new IllegalArgumentException("Invalid MovieCode: " + code);
        };
    }

    /**
     * Gets a movie by its ID.
     *
     * @param movieId The ID of the movie to retrieve.
     * @return The movie object with the specified ID.
     * @throws MovieNotFoundException If the requested movie is not found.
     */
    public static Movie getMovieById(String movieId) {
        Movie movie = movieMap.getOrDefault(movieId, null);
        if (Objects.isNull(movie))
            throw new MovieNotFoundException("Movie " + movieId + " not found.");
        return movie;
    }
}

