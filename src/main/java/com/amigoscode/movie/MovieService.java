package com.amigoscode.movie;

import com.amigoscode.exception.NotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieDao movieDao;

    public MovieService(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    public List<Movie> getMovies() {
        return movieDao.selectMovies();
    }

    public void addNewMovie(Movie movie) {
        // TODO: check if movie exists
        int result = movieDao.insertMovie(movie);
        if (result != 1) {
            throw new IllegalStateException("Oops, something went wrong");
        }
    }

    public void deleteMovie(Integer id) {
        Optional<Movie> movies = movieDao.selectMovieById(id);
        movies.ifPresentOrElse(movie -> {
            int result = movieDao.deleteMovie(id);
            if (result != 1) {
                throw new IllegalStateException("Oops, could not delete movie");
            }
        }, () -> {
            throw new NotFoundException(String.format("Movie with id %s not found", id));
        });
    }

    public Movie getMovie(int id) {
        return movieDao.selectMovieById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Movie with id %s not found", id)));
    }

    public Movie updateMovie(int id, MovieUpdateRequest request) {
        int rowsAffected = movieDao.updateMovie(id, request.getName(), request.getReleaseDate());
        if (rowsAffected > 0) {
            return movieDao.selectMovieById(id)
                    .orElseThrow(() -> new NotFoundException(String.format("Movie with id %s not found", id)));
        } else {
            throw new NotFoundException(String.format("Movie with id %s not found", id));
        }
    }
}
