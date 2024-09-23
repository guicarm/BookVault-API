package br.com.bookvault.book;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // Retorna o catálogo com todos os livros com paginação
    public Page<Book> findAllBooks(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    // Retorna um livro pelo seu título
    public Optional<Book> findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    // Cria um novo livro
    public Book create(Book book) {
        return bookRepository.save(book);
    }
}

