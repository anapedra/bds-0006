package com.devsuperior.movieflix.controllers;

import com.devsuperior.movieflix.Services.GenreService;
import com.devsuperior.movieflix.dto.GenreDTO;
import com.devsuperior.movieflix.dto.UserDTO;
import com.devsuperior.movieflix.dto.UserInsertDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/genres")
public class GenreResource {
  @Autowired
  private GenreService service;

  @GetMapping
  public ResponseEntity<List<GenreDTO>> findAll() {
    List<GenreDTO> list = service.findAll();
    return ResponseEntity.ok().body(list);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<GenreDTO> findById(@PathVariable Long id) {
    GenreDTO dto = service.findById(id);
    return ResponseEntity.ok().body(dto);
  }


}
