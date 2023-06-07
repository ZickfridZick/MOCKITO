package ru.netology;

public class MovieManager {
    private Movie[] movies;
    private int limit;

    public MovieManager() {
        this.movies = new Movie[0];
        this.limit = 5; // Установка лимита по умолчанию равного 5
    }

    public MovieManager(int limit) {
        this.movies = new Movie[0];
        this.limit = limit; // Установка пользовательского лимита
    }

    public void addMovie(Movie movie) {
        Movie[] newArray = new Movie[movies.length + 1];
        System.arraycopy(movies, 0, newArray, 0, movies.length);
        newArray[newArray.length - 1] = movie;
        movies = newArray; // Добавление нового фильма в массив фильмов
    }

    public Movie[] getAllMovies() {
        return movies; // Возвращение всех фильмов
    }

    public Movie[] getLastMovies() {
        int resultLength;
        if (movies.length <= limit) {
            resultLength = movies.length;
        } else {
            resultLength = limit;
        }

        Movie[] result = new Movie[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = movies[movies.length - 1 - i];
        }

        return result; // Возвращение последних фильмов в обратном порядке
    }
}
