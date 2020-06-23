package com.codecool.moviereactorapplication.entity;

import com.codecool.moviereactorapplication.model.MovieType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Movie {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private MovieType movieType;

    private Integer movieDbId;

    @OneToMany(mappedBy = "movie", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Show> shows;

}
