package com.amigoscode.movie;

import java.time.LocalDate;

public class MovieUpdateRequest {
    private String newName;
    private LocalDate releaseDate;

    public String getName() {
        return newName;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }
}
