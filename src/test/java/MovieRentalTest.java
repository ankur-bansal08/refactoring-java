import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MovieRentalTest {

    @Test
    void testGetRentalAmount() {
        Movie mockMovie1 = Mockito.mock(Movie.class);
        when(mockMovie1.calculateRent(anyInt())).thenReturn(2.0);

        MovieRental rental = new MovieRental(mockMovie1, 3);
        double rentalAmount = rental.getRentalAmount();

        assertEquals(2.0, rentalAmount, 0.001); // Check with a delta for double comparison
    }

    @Test
    void testGetFrequentEnterPoints() {
        Movie mockMovie1 = Mockito.mock(Movie.class);
        when(mockMovie1.calculateFrequentEnterPoints(anyInt())).thenReturn(1);
        MovieRental rental = new MovieRental(mockMovie1, 2);
        int frequentEnterPoints = rental.getFrequentEnterPoints();

        assertEquals(1, frequentEnterPoints);
    }

    @Test
    void testConstructorWithInvalidRentalDuration() {
        Movie mockMovie1 = Mockito.mock(Movie.class);
        assertThrows(IllegalArgumentException.class, () -> new MovieRental(mockMovie1, -1));
    }

    @Test
    void testConstructorWithInvalidMovieId() {
        assertThrows(NullPointerException.class, () -> new MovieRental(null, -1));
    }
}

