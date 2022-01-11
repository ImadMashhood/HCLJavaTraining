import java.util.Comparator;

public class CompareRating implements Comparator<Movie> {
    public int compare(Movie a, Movie b) {
        if (a.getRating() < b.getRating()) return -1;
        if(a.getRating() < b.getRating()) return 1;
        else return 0;
    }
}