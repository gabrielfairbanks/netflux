package com.fairbanks.netflux.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document
@NoArgsConstructor
@Builder
public class Movie {

    private String id;

    @NonNull
    private String title;

}
