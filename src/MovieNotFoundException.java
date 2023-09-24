/**
 * Exception thrown when a movie is not found.
 *
 * <p>This exception is typically thrown when attempting to retrieve a movie that does not exist
 * in the movie database.
 */
public class MovieNotFoundException extends RuntimeException {

    /**
     * Constructs a new MovieNotFoundException with the specified detail message.
     *
     * @param message The detail message that describes the reason for the exception.
     */
    public MovieNotFoundException(String message) {
        super(message);
    }
}
