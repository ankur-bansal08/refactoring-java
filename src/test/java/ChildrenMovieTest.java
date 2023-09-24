import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChildrenMovieTest {

    private ChildrenMovie movie;

    @BeforeEach
    void setUp() {
        movie = new ChildrenMovie("F001", "Children's Movie");
    }

    @Test
    void testCalculateRentForOneDayRental() {

        double rentalAmount = movie.calculateRent(1);
        assertEquals(1.5, rentalAmount, 0.001);
    }

    @Test
    void testCalculateRentForThreeDaysRental() {
        double rentalAmount = movie.calculateRent(3);
        assertEquals(1.5, rentalAmount, 0.001);
    }

    @Test
    void testCalculateRentForFourDaysRental() {
        double rentalAmount = movie.calculateRent(4);
        assertEquals(3.0, rentalAmount, 0.001);
    }

    @Test
    void testCalculateFrequentEnterPoints() {
        int frequentEnterPoints = movie.calculateFrequentEnterPoints(1);
        assertEquals(1, frequentEnterPoints);
    }
}

