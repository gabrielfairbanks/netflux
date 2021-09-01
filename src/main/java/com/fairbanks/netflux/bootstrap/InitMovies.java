package com.fairbanks.netflux.bootstrap;

import com.fairbanks.netflux.domain.Movie;
import com.fairbanks.netflux.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;


@Component
@RequiredArgsConstructor
public class InitMovies implements CommandLineRunner {

    private final MovieRepository movieRepository;


    @Override public void run(String... args) throws Exception {
        movieRepository
            .deleteAll()
            .thenMany(Flux.just("Goonies", "Back to the Future", "Indiana Jones", "Pirates of Caribbean", "Matrix", "Poltergeist", "Honey I shrunk the kids", "Groundhog day",
                "Lord of the Rings", "Cruella", "Star Wars")
                .map(title -> Movie.builder().title(title).build())
                .flatMap(movieRepository::save)
            ).subscribe(null, null, () ->
                    movieRepository.findAll().subscribe(System.out::println)
            );

    }
}
