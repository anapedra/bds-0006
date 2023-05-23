package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

public class ReviewDTO implements Serializable {
    private static final long serialVersionUID=1L;

        private Long id;
      //@Column(columnDefinition = "TEXT")
        @Lob
        @NotBlank(message = "Campo obrigatório!")
        private String text;
        private Long movieId;
        private UserDTO userDTO;



    public ReviewDTO() {

    }

    public ReviewDTO(Long id, String text, Long movieId, UserDTO userDTO) {
        this.id = id;
        this.text = text;
        this.movieId = movieId;
        this.userDTO = userDTO;
    }

    public ReviewDTO(Review entytie) {
        id = entytie.getId();
        text = entytie.getText();
        movieId = entytie.getMovie().getId();

    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReviewDTO)) return false;
        ReviewDTO reviewDTO = (ReviewDTO) o;
        return Objects.equals(id, reviewDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
