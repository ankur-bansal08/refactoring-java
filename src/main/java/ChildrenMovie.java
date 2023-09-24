/**
 * Represents a ChildrenMovie.
 */
public class ChildrenMovie extends Movie {
    private static final double DAILY_RENTAL_RATE = 1.5;
    private static final double DEFAULT_RENTAL_AMOUNT = 1.5;
    private static final int DAYS_THRESHOLD = 3;

    /**
     * Constructs a ChildrenMovie with the given ID and title.
     *
     * @param id    The movie's ID.
     * @param title The movie's title.
     */
    public ChildrenMovie(String id, String title) {
        super(id, title);
    }

    /**
     * Calculates the rental amount for the ChildrenMovie based on the number of days rented.
     *
     * @param days The number of days rented.
     * @return The rental amount.
     */
    @Override
    public double calculateRent(int days) {
        if (days > DAYS_THRESHOLD) {
            return ((days - DAYS_THRESHOLD) * DAILY_RENTAL_RATE) + DEFAULT_RENTAL_AMOUNT;
        }
        return DEFAULT_RENTAL_AMOUNT;
    }

    /**
     * Calculates the frequent enter points earned for renting a ChildrenMovie based on the number of days rented.
     *
     * @param days The number of days rented.
     * @return The frequent enter points earned.
     */
    @Override
    public int calculateFrequentEnterPoints(int days) {
        return 1;
    }
}
