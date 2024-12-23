import java.util.Objects;

public class Movie {
    private int rank;
    private String title;
    private int year;
    private double rating;

    public Movie(int rank, String title, int year, double rating) {
        this.rank = rank;
        this.title = title;
        this.year = year;
        this.rating = rating;
    }

    public double getRating() {
        return rating;
    }

    public int getRank() {
        return rank;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return String.format("%d. %s (%d) - Rating: %.1f", rank, title, year, rating);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Movie movie = (Movie) obj;
        return rank == movie.rank &&
                year == movie.year &&
                Double.compare(movie.rating, rating) == 0 &&
                title.equals(movie.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, title, year, rating);
    }
}
