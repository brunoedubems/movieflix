package br.com.brunoedubems.movieflix.repository;

import br.com.brunoedubems.movieflix.entity.Category;
import br.com.brunoedubems.movieflix.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findMovieByCategories(List<Category> categories);
}
