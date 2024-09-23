package br.com.bookvault.author;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    
    Optional<Author> findByNameIgnoreCase(String name);

    Page<Author> findAll(Pageable pageable);
}
