package br.com.bookvault.book;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.bookvault.book.dto.BookRequest;
import br.com.bookvault.book.dto.BookResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("books")
@Slf4j
@Tag(name = "BOOKS")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookService bookService;

    
    // ========== GET(Listar Todos os Livros com Paginação) ============
    @Operation(
        summary = "List all books with pagination.",
        description = "Retorna uma lista paginada com todos os livros registrados."
    )
    @GetMapping
    public ResponseEntity<Page<Book>> getAllBooks(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Book> books = bookService.findAllBooks(pageable);
        return ResponseEntity.ok(books);
    }

    // ========== GET(Buscar Livro por Nome) ============
    @Operation(
        summary = "Get book by title.",
        description = "Retorna um livro de acordo com seu título."
    )
    @RequestMapping("/search")
    public ResponseEntity<BookResponse> findByTitle(@RequestParam String title) {
        Optional<Book> book = bookService.findByTitle(title);
        if (book.isPresent()) {
            return ResponseEntity.ok(BookResponse.from(book.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // ========== POST(Criar Novo Livro) ============
    @Operation(
        summary = "Create new book.",
        description = "Cria um novo livro no banco."
    )
    @PostMapping
    public ResponseEntity<BookResponse> create(@RequestBody BookRequest bookRequest, UriComponentsBuilder uriBuilder) {
        Book book = bookService.create(bookRequest.toModel());

        var uri = uriBuilder
                    .path("/books/{id}")
                    .buildAndExpand(book.getId())
                    .toUri();

        return ResponseEntity
                .created(uri)
                .body(BookResponse.from(book));
    }
}

