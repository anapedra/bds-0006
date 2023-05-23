package com.devsuperior.movieflix.Services;

import com.devsuperior.movieflix.Services.exceptionservice.DataBaseException;
import com.devsuperior.movieflix.Services.exceptionservice.ResourceNotFoundException;
import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.dto.RoleDTO;
import com.devsuperior.movieflix.dto.UserDTO;
import com.devsuperior.movieflix.entities.*;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import com.devsuperior.movieflix.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository repository;
    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private  MovieRepository movieRepository;
    @Autowired
    private AuthService authService;


    @Transactional
    public ReviewDTO insert(ReviewDTO dto) {
        var review=new Review();
        review.setText(dto.getText());
        Movie movie=new Movie();
        movie.setId(dto.getMovieId());
        review.setMovie(movie);
        User user=new User();
        review.setUser(dto.getUserDTO().getAuthorities());
        review=repository.save(review);
        return new ReviewDTO(review);
    }
}







