// package br.com.bookvault.book;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
// import org.springframework.web.bind.annotation.*;

// import io.swagger.v3.oas.annotations.Operation;

// @RestController
// @RequestMapping("/book")
// public class BookController {

//     @Autowired
//     private BookService bookService;


    
//     // ========== GET(Buscar livros pelo título) ============
//        @Operation(
//         summary = "Get books by title.",
//         description = "Retorna um livro de acordo com seu título."
//     )
//     @GetMapping("/search")
//     public Page<Book> searchBooksByTitle(@RequestParam String title, Pageable pageable) {
//         return bookService.searchBooksByTitle(title, pageable);
//     }

      
// // Endpoint para listar livros com paginação
//       @GetMapping
//       public Page<Book> listBooks(Pageable pageable) {
//           return bookService.getBooks(pageable);
//       }


//     // Endpoint para adicionar um livro
//     @PostMapping
//     public Book addBook(@RequestBody Book book) {
//         return bookService.addBook(book);
//     }

  

 

//     // Outros endpoints para livros...
// }
