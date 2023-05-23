package com.devsuperior.movieflix.Services;

import com.devsuperior.movieflix.Services.exceptionservice.DataBaseException;
import com.devsuperior.movieflix.Services.exceptionservice.ResourceNotFoundException;
import com.devsuperior.movieflix.dto.GenreDTO;
import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.repositories.GenreRepository;
import com.devsuperior.movieflix.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GenreService {

    @Autowired
    private  MovieRepository movieRepository;
    @Autowired
    private  GenreRepository repository;


    @Transactional(readOnly = true)
    public List<GenreDTO> findAll() {
        List<Genre> list = repository.findAll();
        return list.stream().map(x -> new GenreDTO(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public GenreDTO findById(Long id) {
        Optional<Genre> obj = repository.findById(id);
        Genre entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new GenreDTO(entity);
    }




}


