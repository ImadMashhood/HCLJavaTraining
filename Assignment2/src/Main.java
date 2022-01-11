import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        String line = "----------------------------------";
        //Create Movies
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie("The Godfather", 9.7, 1972));
        movies.add(new Movie("Interstellar", 9.8, 2014));
        movies.add(new Movie("Star Wars: The Empire Strikes Back", 8.9, 1980));
        movies.add(new Movie("Blade RUnner", 8.7, 1982));

        //COmpare Names
        System.out.println(line+"\n         Sorted By Name\n"+line);
        CompareName a = new CompareName();
        Collections.sort(movies, a);
        for (Movie movie: movies) {
            System.out.println( movie.getName() + " " +
                    movie.getRating() + " " +
                    movie.getYear());
        }

        //Compare Ratings
        System.out.println("\n"+line+"\n         Sorted By Rating\n"+line);
        CompareRating b = new CompareRating();
        Collections.sort(movies, b);
        for (Movie movie: movies) {
            System.out.println( movie.getName() + " " +
                    movie.getRating() + " " +
                    movie.getYear());
        }

        //Compare Years
        System.out.println("\n"+line+"\n         Sorted By Year\n"+line);
        Collections.sort(movies);
        Iterator<Movie> iterator = movies.iterator();
        while (iterator.hasNext()) {
            Movie movie = (Movie)iterator.next();
            System.out.println( movie.getName() + " " +
                    movie.getRating() + " " +
                    movie.getYear());
        }
    }
}
