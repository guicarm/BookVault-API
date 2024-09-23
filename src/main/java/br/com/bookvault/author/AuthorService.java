package br.com.bookvault.author;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    
    @Autowired
    private AuthorRepository authorRepository;

    // Retorna uma lista com todos os autores com paginação
    public Page<Author> findAllAuthors(int page) {
        return authorRepository.findAll(PageRequest.of(page, 5));
    }

    // Retorna um autor pelo nome
    public Optional<Author> findByName(String name) {
        return authorRepository.findByNameIgnoreCase(name);
    }
}