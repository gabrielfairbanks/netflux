package com.fairbanks.netflux.controllers;

import com.fairbanks.netflux.domain.Movie;
import com.fairbanks.netflux.domain.MovieEvent;
import com.fairbanks.netflux.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RequiredArgsConstructor
@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/{id}")
    Mono<Movie> getMovieById(@PathVariable String id){
        return movieService.getMovieById(id);
    }

    @GetMapping Flux<Movie> getMovies(){
        return movieService.getAllMovies();
    }

    @GetMapping(value = "/{id}/events", produces = MediaType.APPLICATION_NDJSON_VALUE)
    Flux<MovieEvent> streamMovieEvents(@PathVariable String id){
        return movieService.streamMovieEvents(id);
    }
}
