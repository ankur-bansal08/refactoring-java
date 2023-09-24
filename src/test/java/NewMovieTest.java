import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class NewMovieTest {

    private NewMovie movie;

    @BeforeEach
    void setUp() {
        movie = new NewMovie("F001", "New Release Movie");
    }

    @Test
    void testCalculateRentForOneDayRental() {
        double rentalAmount = movie.calculateRent(1);
        assertEquals(3.0, rentalAmount, 0.001);
    }

    @Test
    void testCalculateRentForThreeDaysRental() {
        double rentalAmount = movie.calculateRent(3);
        assertEquals(9.0, rentalAmount, 0.001);
    }

    @Test
    void testCalculateRentForZeroDaysRental() {
        double rentalAmount = movie.calculateRent(0);
        assertEquals(0.0, rentalAmount, 0.001);
    }

    @Test
    void testCalculateFrequentEnterPointsForOneDayRental() {
        int frequentEnterPoints = movie.calculateFrequentEnterPoints(1);
        assertEquals(1, frequentEnterPoints);
    }

    @Test
    void testCalculateFrequentEnterPointsForThreeDaysRental() {
        int frequentEnterPoints = movie.calculateFrequentEnterPoints(3);
        assertEquals(2, frequentEnterPoints);
    }

}

