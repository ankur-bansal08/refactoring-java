import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieFactoryTest {

    @Test
    void testGetRegularMovie() {
        Movie movie = MovieFactory.getMovie(MovieCategoryType.REGULAR, "F001", "Regular Movie");
        assertTrue(movie instanceof RegularMovie);
    }

    @Test
    void testGetChildrenMovie() {
        Movie movie = MovieFactory.getMovie(MovieCategoryType.CHILDREN, "F002", "Children's Movie");
        assertTrue(movie instanceof ChildrenMovie);
    }

    @Test
    void testGetNewMovie() {
        Movie movie = MovieFactory.getMovie(MovieCategoryType.NEW, "F003", "New Release Movie");
        assertTrue(movie instanceof NewMovie);
    }

    @Test
    void testGetMovieForInvalidCode() {
        assertThrows(IllegalArgumentException.class, () ->
                MovieFactory.getMovie(null, "F004", "Invalid Movie"));
    }

    @Test
    void testGetMovieForExistingMovieId() {
        assertEquals("F001", MovieFactory.getMovieById("F001").getId());
    }

    @Test
    void testGetMovieForNonExistingMovieId() {
        assertThrows(MovieNotFoundException.class, () -> MovieFactory.getMovieById("random"));
    }
}

