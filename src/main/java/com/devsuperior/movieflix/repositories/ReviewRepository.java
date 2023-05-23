package com.devsuperior.movieflix.repositories;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {

/*
    @Query("SELECT obj FROM Review obj INNER JOIN fetch obj.movie r WHERE " +
            " (COALESCE(:movie) IS NULL OR r IN :movie)")
    List<Review> findReviewByMovie(Movie movie);

 */



}
