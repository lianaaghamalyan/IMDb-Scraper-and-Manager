import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;

public class Scraper {
    private Stack<Movie> movieStack;

    public Scraper() {
        this.movieStack = new Stack<>();
    }

    public Stack<Movie> getMovieStack() {
        return movieStack;
    }

    public void scrapeIMDb(int limit) {
        String url = "https://www.imdb.com/chart/top/";

        try {
            Document document = Jsoup.connect(url).get();

            Elements movieElements = document.select("li.ipc-metadata-list-summary-item");

            FileWriter csvWriter = new FileWriter("imdb_top.csv");
            csvWriter.append("Rank, Title, Year, Rating\n");

            int count = 0;

            for (Element movieElement : movieElements) {
                try {
                    // Extract Rank and Title
                    String rawTitle = movieElement.select("h3.ipc-title__text").text(); // E.g., "1. The Shawshank Redemption"
                    String rank = rawTitle.split("\\.")[0].trim(); // Extract the rank (e.g., "1")
                    String title = rawTitle.replaceFirst("^\\d+\\.\\s*", ""); // Extract the title (e.g., "The Shawshank Redemption")

                    // Extract Year
                    String year = movieElement.select(".cli-title-metadata-item").first().text();

                    // Extract Rating
                    String rating = movieElement.select(".ipc-rating-star--rating").text();

                    // Create a Movie object
                    Movie movie = new Movie(Integer.parseInt(rank), title, Integer.parseInt(year), Double.parseDouble(rating));
                    movieStack.push(movie);

                    // Write to CSV
                    csvWriter.append(movie.getRank() + "," + " ")
                            .append(movie.getTitle() + "," + " ")
                            .append(movie.getYear() + "," + " ")
                            .append(movie.getRating() + "\n");

                    count++;
                    if (count >= limit) break; // Use the passed limit to stop scraping
                } catch (Exception e) {
                    System.out.println("Failed to parse movie element: " + e.getMessage());
                }
            }

            csvWriter.flush();
            csvWriter.close();
            System.out.println("Data successfully scraped and saved to imdb_top.csv");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
