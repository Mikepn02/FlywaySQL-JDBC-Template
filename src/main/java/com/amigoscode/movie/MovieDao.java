package com.amigoscode.movie;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MovieDao {
    List<Movie> selectMovies();
    int insertMovie(Movie movie);
    int deleteMovie(int id);
    Optional<Movie> selectMovieById(int id);

    int updateMovie(int id, String name , LocalDate release_date);
}
