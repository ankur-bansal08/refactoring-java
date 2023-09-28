import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MovieTest {

    private Movie movie;

    @Test
    void testCalculateRentForRegularMovie() {
        movie = new RegularMovie("F001", "You've Got Mail");
        double rentalAmount = movie.calculateRent(3);
        assertEquals(3.5, rentalAmount, 0.001);
    }

    @Test
    void testCalculateFrequentEnterPointsForRegularMovie() {
        movie = new RegularMovie("F001", "You've Got Mail");
        int frequentEnterPoints = movie.calculateFrequentEnterPoints(3);
        assertEquals(1, frequentEnterPoints);
    }

    @Test
    void testCalculateRentForChildrenMovie() {
        movie = new ChildrenMovie("F003", "Cars");
        double rentalAmount = movie.calculateRent(4);
        assertEquals(3.0, rentalAmount, 0.001);
    }

    @Test
    void testCalculateFrequentEnterPointsForChildrenMovie() {
        movie = new ChildrenMovie("F003", "Cars");
        int frequentEnterPoints = movie.calculateFrequentEnterPoints(4);
        assertEquals(1, frequentEnterPoints);
    }

    @Test
    void testCalculateRentForNewMovie() {
        movie = new NewMovie("F004", "Fast & Furious X");
        double rentalAmount = movie.calculateRent(2);
        assertEquals(6.0, rentalAmount, 0.001);
    }

    @Test
    void testCalculateFrequentEnterPointsForNewMovie() {
        movie = new NewMovie("F004", "Fast & Furious X");
        int frequentEnterPoints = movie.calculateFrequentEnterPoints(2);
        assertEquals(1, frequentEnterPoints);
    }
}
