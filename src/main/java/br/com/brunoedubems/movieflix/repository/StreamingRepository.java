package br.com.brunoedubems.movieflix.repository;

import br.com.brunoedubems.movieflix.entity.Streaming;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreamingRepository extends JpaRepository<Streaming, Long> {
}
