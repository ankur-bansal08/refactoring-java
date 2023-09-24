import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String expected = """
                Rental Record for C. U. Stomer
                \tYou've Got Mail\t3.5
                \tMatrix\t2.0
                Amount owed is 5.5
                You earned 2 frequent points
                """;

        List<MovieRental> movieRentalList = Arrays.asList(new MovieRental("F001", 3),
                new MovieRental("F002", 1));
        Customer customer = new Customer("C. U. Stomer", movieRentalList);

        String result = customer.getStatement();

        if (!result.equals(expected)) {
            throw new AssertionError("Expected: " + System.lineSeparator()
                    + String.format(expected) + System.lineSeparator() + System.lineSeparator()
                    + "Got: " + System.lineSeparator() + result);
        }

        System.out.println("SUCCESS");
        System.out.println(result);
    }
}
