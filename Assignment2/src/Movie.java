public class Movie implements Comparable<Movie> {

    //Initialize
    private String name;
    private double rating;
    private int year;

    //Constructor
    public Movie(String name, double rating, int year) {
        this.name = name;
        this.rating = rating;
        this.year = year;
    }

    //Comparators
    public int compareTo(Movie movie) {
        return this.year - movie.year;
    }

    //Getters
    public String getName() {
        return name;
    }
    public double getRating() {
        return rating;
    }
    public int getYear() {
        return year;
    }
}
