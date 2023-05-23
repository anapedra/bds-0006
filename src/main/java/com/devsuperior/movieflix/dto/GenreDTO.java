package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GenreDTO implements Serializable {
    private static final long serialVersionUID=1L;

    private Long id;
    private String name;


    public GenreDTO() {

    }

    public GenreDTO(Long id, String name) {
        this.id = id;
        this.name = name;

    }
    public GenreDTO(Genre entity) {
        id = entity.getId();
        name= entity.getName();

    }
    public GenreDTO(Genre entity, List<Movie> movies) {
        this(entity);


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GenreDTO)) return false;
        GenreDTO genreDTO = (GenreDTO) o;
        return Objects.equals(id, genreDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
