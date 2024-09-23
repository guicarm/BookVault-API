package br.com.bookvault.author;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("authors")
@Tag(name = "AUTHORS")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    // ========== GET(Listar Todos os Autores com Paginação) ============
    @Operation(
        summary = "List all authors with pagination.",
        description = "Retorna uma lista com todos os autores registrados."
    )
    @GetMapping
    public Page<Author> getAllAuthors(@RequestParam(defaultValue = "0") int page) {
        return authorService.findAllAuthors(page);
    }

    // ========== GET(Buscar Autor por Nome) ============
    @Operation(
        summary = "Get author by name.",
        description = "Retorna um autor de acordo com seu nome."
    )
    @GetMapping("/search")
    public ResponseEntity<Author> findByName(@RequestParam String name) {
        Optional<Author> author = authorService.findByName(name);
        if (author.isPresent()) {
            return ResponseEntity.ok(author.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

