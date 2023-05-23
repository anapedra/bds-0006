package com.devsuperior.movieflix.controllers;

import com.devsuperior.movieflix.Services.MovieService;
import com.devsuperior.movieflix.dto.GenreDTO;
import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.dto.ReviewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/movies")
public class MovieResource {
    @Autowired
    private MovieService service;

    @GetMapping
    public ResponseEntity<Page<MovieDTO>> findAll(
            @RequestParam(value = "genreId",defaultValue = "0") Long genreId,
            @RequestParam(value = "title",defaultValue = "") String title,
            Pageable pageable) {
        Page<MovieDTO> page = service.pageMovie(genreId,title,pageable);
        return ResponseEntity.ok().body(page);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<MovieDTO> findById(@PathVariable Long id) {
        MovieDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

}
