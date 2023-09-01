package com.amigoscode.movie;

import com.amigoscode.actor.Actor;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;

public record Movie(
        @JsonProperty("id") Integer id,
        @JsonProperty("name") String name,
        @JsonProperty("actors") List<Actor> actors,
        @JsonProperty("release_date") LocalDate releaseDate) {

    public Movie(
            @JsonProperty("id") Integer id,
            @JsonProperty("name") String name,
            @JsonProperty("actors") List<Actor> actors,
            @JsonProperty("release_date") LocalDate releaseDate) {
        this.id = id;
        this.name = name;
        this.actors = actors;
        this.releaseDate = releaseDate;
    }


}
