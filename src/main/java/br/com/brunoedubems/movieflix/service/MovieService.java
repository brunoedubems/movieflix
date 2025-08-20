package br.com.brunoedubems.movieflix.service;

import br.com.brunoedubems.movieflix.entity.Category;
import br.com.brunoedubems.movieflix.entity.Movie;
import br.com.brunoedubems.movieflix.entity.Streaming;
import br.com.brunoedubems.movieflix.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final CategoryService categoryService;
    private final StreamingService streamingService;

    public Movie save(Movie movie) {
        movie.setCategories(this.findCategories(movie.getCategories()));
        movie.setStreamings(this.findStreamings(movie.getStreamings()));
        return movieRepository.save(movie);
    }

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    public List<Movie> findByCategory(Long categoryId) {
    return movieRepository.findMovieByCategories(List.of(Category.builder().id(categoryId).build()));
    }

    public Optional<Movie> findById(Long id) {
        return movieRepository.findById(id);
    }

    public Optional<Movie> update(Long idMovie, Movie updateMovie) {
        Optional<Movie> optMovie = movieRepository.findById(idMovie);

        if (optMovie.isPresent()) {
            List<Category> categories = this.findCategories(updateMovie.getCategories());
            List<Streaming> streamings = this.findStreamings(updateMovie.getStreamings());

            Movie movie = optMovie.get();
            movie.setTitle(updateMovie.getTitle());
            movie.setDescription(updateMovie.getDescription());
            movie.setReleaseDate(updateMovie.getReleaseDate());
            movie.setRating(updateMovie.getRating());

            movie.getCategories().clear();
            movie.getCategories().addAll(categories);

            movie.getStreamings().clear();
            movie.getStreamings().addAll(streamings);

            movieRepository.save(movie);
            return Optional.of(movie);
        }
        return Optional.empty();
    }

    public void delete(Long movieId){
        movieRepository.deleteById(movieId);
    }


    private List<Category> findCategories(List<Category> categories) {
       /* List<Category> categoriesFound =new ArrayList<>();
        categories.forEach(category ->{
            categoryService.findById(category.getId())
                    .ifPresent(categoriesFound::add);
                });
        return categoriesFound;*/

        //refatoração - testando, se tiver tudo ok, deletar o codigo comentado acima
        return categories.stream()
                .map(category -> categoryService.findById(category.getId()))
                .flatMap(Optional::stream) // pega só os que existem
                .toList(); // Java 16+ (ou use Collectors.toList() em versões antigas)
    }

    private List<Streaming> findStreamings(List<Streaming> streamings) {
        return streamings.stream()
                .map(streaming -> streamingService.findById(streaming.getId()))
                .flatMap(Optional::stream)
                .toList();
    }

}
