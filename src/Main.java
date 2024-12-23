import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scraper scraper = new Scraper();
        scraper.scrapeIMDb(25);

        Stack<Movie> movieStack = scraper.getMovieStack();

        // Print unsorted movies
        System.out.println("Unsorted movies => ");
        movieStack.printAll();

        // Search methods N1

        // Search for a specific movie
//        Movie searchMovie = new Movie(13, "Fight Club", 1999, 8.8);
//        boolean found = movieStack.search(searchMovie);
//        System.out.println("\nSearching for 'Fight Club': " + (found ? "Found" : "Not Found"));


        // Remove the top movie
        Movie removedMovie = movieStack.pop();
        System.out.println("\nRemoved the top movie: " + (removedMovie != null ? removedMovie : "No movie to remove"));

        // Print remaining movies after removal
        System.out.println("\nMovies after removal:");
        movieStack.printAll();

        // Sort the stack using insertion sort
        ArrayList<Movie> sortedMovies = InsertionSort.sort(movieStack, Comparator.comparingDouble(Movie::getRating).reversed());

        // Print sorted movies
        System.out.println("\nSorted movies:");
        for (Movie movie : sortedMovies) {
            System.out.println(movie);
        }

        // user input for searching
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n Bonus :P Enter movie title to search: ");
        String searchTitle = scanner.nextLine();

        if (movieStack.search(searchTitle)) {
            System.out.println("Movie '" + searchTitle + "' found.");
        } else {
            System.out.println("Movie '" + searchTitle + "' not found.");
        }

        scanner.close();
    }
}
