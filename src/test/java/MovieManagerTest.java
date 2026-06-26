import org.example.MovieManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {

    @Test
    void shouldAddMovie() {
        MovieManager manager = new MovieManager();

        manager.add("Movie 1");

        String[] expected = {"Movie 1"};
        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    void shouldFindAllMovies() {
        MovieManager manager = new MovieManager();

        manager.add("Movie 1");
        manager.add("Movie 2");
        manager.add("Movie 3");

        String[] expected = {
                "Movie 1",
                "Movie 2",
                "Movie 3"
        };

        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    void shouldReturnLastFiveMoviesDefaultLimit() {
        MovieManager manager = new MovieManager();

        manager.add("1");
        manager.add("2");
        manager.add("3");
        manager.add("4");
        manager.add("5");
        manager.add("6");
        manager.add("7");

        String[] expected = {
                "7",
                "6",
                "5",
                "4",
                "3"
        };

        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    void shouldReturnAllMoviesIfLessThanLimit() {
        MovieManager manager = new MovieManager();

        manager.add("1");
        manager.add("2");
        manager.add("3");

        String[] expected = {
                "3",
                "2",
                "1"
        };

        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    void shouldReturnMoviesIfEqualLimit() {
        MovieManager manager = new MovieManager();

        manager.add("1");
        manager.add("2");
        manager.add("3");
        manager.add("4");
        manager.add("5");

        String[] expected = {
                "5",
                "4",
                "3",
                "2",
                "1"
        };

        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    void shouldReturnLastThreeMoviesCustomLimit() {
        MovieManager manager = new MovieManager(3);

        manager.add("1");
        manager.add("2");
        manager.add("3");
        manager.add("4");
        manager.add("5");

        String[] expected = {
                "5",
                "4",
                "3"
        };

        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    void shouldReturnEmptyArray() {
        MovieManager manager = new MovieManager();

        String[] expected = {};

        assertArrayEquals(expected, manager.findLast());
    }
}