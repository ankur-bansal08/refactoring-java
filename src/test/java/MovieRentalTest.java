import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class MovieRentalTest {

    @Test
    void testGetRentalAmount() {
        MovieRental rental = new MovieRental("F001", 3);
        double rentalAmount = rental.getRentalAmount();

        assertEquals(3.5, rentalAmount, 0.001); // Check with a delta for double comparison
    }

    @Test
    void testGetFrequentEnterPoints() {
        MovieRental rental = new MovieRental("F001", 2);
        int frequentEnterPoints = rental.getFrequentEnterPoints();

        assertEquals(1, frequentEnterPoints);
    }

    @Test
    void testConstructorWithInvalidRentalDuration() {
        assertThrows(IllegalArgumentException.class, () -> new MovieRental("F004", -1));
    }

    @Test
    void testConstructorWithInvalidMovieId() {
        assertThrows(NullPointerException.class, () -> new MovieRental(null, -1));
    }
}

