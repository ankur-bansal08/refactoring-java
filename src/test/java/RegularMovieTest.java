import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("RegularMovie Test")
class RegularMovieTest {

    private Movie movie;

    @BeforeEach
    void setUp() {
        movie = new RegularMovie("F001", "Regular Movie");
    }

    @Test
    void testCalculateRentForTwoDaysRental() {
        double rentalAmount = movie.calculateRent(2);
        assertEquals(2.0, rentalAmount, 0.001);
    }

    @Test
    void testCalculateRentForThreeDaysRental() {
        double rentalAmount = movie.calculateRent(3);
        assertEquals(3.5, rentalAmount, 0.001);
    }

    @Test
    void testCalculateFrequentEnterPoints() {
        int frequentEnterPoints = movie.calculateFrequentEnterPoints(1);
        assertEquals(1, frequentEnterPoints);
    }

}

