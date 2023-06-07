package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MovieManagerTest {
    @Test
    public void shouldAddMovie() {
        MovieManager manager = new MovieManager();
        Movie movie = new Movie("Movie 1");
        manager.addMovie(movie);
        Movie[] expected = {movie};
        assertArrayEquals(expected, manager.getAllMovies());
    }

    @Test
    public void shouldGetAllMovies() {
        MovieManager manager = new MovieManager();
        Movie movie1 = new Movie("Movie 1");
        Movie movie2 = new Movie("Movie 2");
        manager.addMovie(movie1);
        manager.addMovie(movie2);
        Movie[] expected = {movie1, movie2};
        assertArrayEquals(expected, manager.getAllMovies());
    }

    @Test
    public void shouldGetLastMoviesWithinLimit() {
        MovieManager manager = new MovieManager(3);
        Movie movie1 = new Movie("Movie 1");
        Movie movie2 = new Movie("Movie 2");
        Movie movie3 = new Movie("Movie 3");
        manager.addMovie(movie1);
        manager.addMovie(movie2);
        manager.addMovie(movie3);
        Movie[] expected = {movie3, movie2, movie1};
        assertArrayEquals(expected, manager.getLastMovies());
    }

    @Test
    public void shouldGetLastMoviesExceedingLimit() {
        MovieManager manager = new MovieManager(2);
        Movie movie1 = new Movie("Movie 1");
        Movie movie2 = new Movie("Movie 2");
        Movie movie3 = new Movie("Movie 3");
        Movie movie4 = new Movie("Movie 4");
        manager.addMovie(movie1);
        manager.addMovie(movie2);
        manager.addMovie(movie3);
        manager.addMovie(movie4);
        Movie[] expected = {movie4, movie3};
        assertArrayEquals(expected, manager.getLastMovies());
    }

    @Test
    public void shouldGetLastMoviesWhenNoMoviesAdded() {
        MovieManager manager = new MovieManager();
        Movie[] expected = new Movie[0];
        assertArrayEquals(expected, manager.getLastMovies());
    }
}
