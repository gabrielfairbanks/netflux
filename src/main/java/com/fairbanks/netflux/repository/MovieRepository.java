package com.fairbanks.netflux.repository;

import com.fairbanks.netflux.domain.Movie;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


public interface MovieRepository extends ReactiveMongoRepository<Movie, String> {

}
