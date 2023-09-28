import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
        MovieRental mockRental = mock(MovieRental.class);
        when(mockRental.getMovie()).thenReturn(new RegularMovie("F001", "You've Got Mail"));
        when(mockRental.getRentalAmount()).thenReturn(2.0);
        when(mockRental.getFrequentEnterPoints()).thenReturn(1);

        // Add the mock rental to the list
        List<MovieRental> movieRentals = new ArrayList<>();
        movieRentals.add(mockRental);
        Customer customer = new Customer("Alice", movieRentals);
        String statement = customer.getStatement();

        String expectedStatement = """
                Rental Record for Alice
                \tYou've Got Mail\t2.0
                Amount owed is 2.0
                You earned 1 frequent points
                """;

        assertEquals(expectedStatement, statement);
    }


    @Test
    void testGetStatementWithNullMovieList() {
        // Create a customer with a null movie rentals list
        Customer customer = new Customer("Alice", null);

        String expected = "No rentals for Alice";
        assertEquals(expected, customer.getStatement());
    }
}

