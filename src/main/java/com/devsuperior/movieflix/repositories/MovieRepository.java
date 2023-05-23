package com.devsuperior.movieflix.repositories;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {

    @Query("SELECT DISTINCT obj FROM Movie obj WHERE "
            + "(:genre IS NULL OR :genre = obj.genre) AND "
            + "(LOWER(obj.title) LIKE LOWER(CONCAT('%',:title,'%'))) order by obj.title")
    Page<Movie> pageMovie(Genre genre, String title, Pageable pageable);



    /*


      @Query("SELECT DISTINCT obj FROM Movie obj WHERE "
            + "(:genre IS NULL OR :genre = obj.genre) AND "
            + "(LOWER(obj.title) LIKE LOWER(CONCAT('%',:title,'%')))")
    Page<Movie> pageMovie(Genre genre, String title, Pageable pageable);


     */







/*


 */



/*
    @Query("SELECT DISTINCT obj FROM Post obj INNER JOIN obj.author aut JOIN obj.categories cats WHERE " +
            " (COALESCE(:author) IS NULL OR aut IN :author) AND " +
            "(COALESCE(:categories) IS NULL OR cats IN :categories) AND " +
            "obj.dataPost BETWEEN :min AND :max ")
    Page<Post> findPost(List<Category> categories, User author, LocalDate min, LocalDate max, Pageable pageable);
    @Query("SELECT obj FROM Post obj JOIN FETCH obj.categories WHERE obj IN :posts")
    List<Post> findAllPost(List<Post>posts);

 */

}
