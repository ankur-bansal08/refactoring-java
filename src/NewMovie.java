/**
 * Represents a NewMovie.
 */
public class NewMovie extends Movie {
    private static final double DAILY_RENTAL_RATE = 3.0;
    private static final double BONUS_FREQUENT_ENTER_POINTS_THRESHOLD = 2.0;

    /**
     * Constructs a NewMovie with the given ID and title.
     *
     * @param id    The movie's ID.
     * @param title The movie's title.
     */
    public NewMovie(String id, String title) {
        super(id, title);
    }

    /**
     * Calculates the rental amount for the NewMovie based on the number of days rented.
     *
     * @param days The number of days rented.
     * @return The rental amount.
     */
    @Override
    public double calculateRent(int days) {
        return days * DAILY_RENTAL_RATE;
    }

    /**
     * Calculates the frequent enter points earned for renting a NewMovie based on the number of days rented.
     *
     * @param days The number of days rented.
     * @return The frequent enter points earned.
     */
    @Override
    public int calculateFrequentEnterPoints(int days) {
        return (days > BONUS_FREQUENT_ENTER_POINTS_THRESHOLD) ? 2 : 1;
    }
}
