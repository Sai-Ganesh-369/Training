import java.util.Objects;

public class Movies {
    String movieName;
    String movieDirector;

    int releaseYear;

    public Movies(String movieName, String movieDirector, int releaseYear) {
        this.movieName = movieName;
        this.movieDirector = movieDirector;
        this.releaseYear = releaseYear;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;
        Movies movies = (Movies) that;
        return releaseYear == movies.releaseYear && Objects.equals(movieName, movies.movieName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieName, releaseYear);
    }
}
