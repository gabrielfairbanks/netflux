package com.fairbanks.netflux.services;

import com.fairbanks.netflux.domain.Movie;
import com.fairbanks.netflux.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override public Mono<Movie> getMovieById(String id) {
        return movieRepository.findById(id);
    }


    @Override public Flux<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
}
