import java.util.Objects;

/**
 * The {@code MovieFactory} class is responsible for creating movie objects based on the provided
 * {@code MovieCode} and other details such as ID and title.
 */
public class MovieFactory {

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
}

