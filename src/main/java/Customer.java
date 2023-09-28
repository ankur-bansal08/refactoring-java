import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Represents a customer who rents movies.
 */
public class Customer {
    private final String name;
    private final List<MovieRental> movieRentals;

    /**
     * Constructs a customer with the given name and a list of movie rentals.
     *
     * @param name         The name of the customer.
     * @param movieRentals The list of movie rentals for the customer.
     * @throws NullPointerException if the customer name is null.
     */
    public Customer(String name, List<MovieRental> movieRentals) {
        Objects.requireNonNull(name, "Customer name cannot be null.");
        this.name = name;
        this.movieRentals = (movieRentals == null) ? Collections.emptyList() : movieRentals;
    }

    /**
     * Gets the name of the customer.
     *
     * @return The name of the customer.
     */
    public String getName() {
        return name;
    }

    /**
     * Generates a statement for the customer's movie rentals, including rental details and total amount.
     *
     * @return The statement as a formatted string.
     * @throws MovieNotFoundException if a movie for a rental is not found.
     */
    public String getStatement() {
        if (movieRentals.isEmpty()) {
            return String.format("No rentals for %s", getName());
        }

        double totalAmount = 0d;
        int frequentEnterPoints = 0;

        StringBuilder result = new StringBuilder();
        for (MovieRental movieRental : movieRentals) {
            Movie movie = movieRental.getMovie();
            if (movie == null) {
                throw new IllegalArgumentException("Movie details are required to generate statement.");
            }

            double rentalAmount = movieRental.getRentalAmount();
            int rentalPoints = movieRental.getFrequentEnterPoints();

            totalAmount += rentalAmount;
            frequentEnterPoints += rentalPoints;

            result.append(String.format("\t%s\t%s%n", movie.getTitle(), rentalAmount));
        }

        return prepareOutputFormat(result.toString(), totalAmount, frequentEnterPoints);
    }

    private String prepareOutputFormat(String movieDetails, double totalAmount, int frequentEnterPoints) {
        return String.format("Rental Record for %s%n%sAmount owed is %s%nYou earned %d frequent points%n",
                getName(), movieDetails, totalAmount, frequentEnterPoints);
    }
}
