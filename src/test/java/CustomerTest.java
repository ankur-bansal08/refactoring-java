import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class CustomerTest {


    @Test
    public void testGetStatementWithNoRentals() {
        Customer customer = new Customer("Alice", Collections.emptyList());
        String statement = customer.getStatement();

        assertEquals("No rentals for Alice", statement);
    }

    @Test
    public void testGetStatementWithRentals() {
        Movie mockMovie1 = Mockito.mock(Movie.class);
        Movie mockMovie2 = Mockito.mock(Movie.class);

        Mockito.when(mockMovie1.getId()).thenReturn("F001");
        Mockito.when(mockMovie2.getId()).thenReturn("F002");

        List<MovieRental> rentals = Arrays.asList(
                new MovieRental(mockMovie1.getId(), 3),
                new MovieRental(mockMovie2.getId(), 2)
        );

        Customer customer = new Customer("Alice", rentals);
        String statement = customer.getStatement();

        String expectedStatement = """
                Rental Record for Alice
                \tYou've Got Mail\t3.5
                \tMatrix\t2.0
                Amount owed is 5.5
                You earned 2 frequent points
                """;

        assertEquals(expectedStatement, statement);
    }

    @Test
    public void testGetStatementWithInvalidMovie() {
        Movie mockInvalidMovie = Mockito.mock(Movie.class);
        Mockito.when(mockInvalidMovie.getId()).thenReturn("d73");

        MovieRental invalidRental = new MovieRental(mockInvalidMovie.getId(), 5);
        Customer customer = new Customer("Alice", Collections.singletonList(invalidRental));

        assertThrows(MovieNotFoundException.class, customer::getStatement);
    }
}

