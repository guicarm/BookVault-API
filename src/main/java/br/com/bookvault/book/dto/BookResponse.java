package br.com.bookvault.book.dto;

import br.com.bookvault.book.Book;

public record BookResponse (
    Long id,
    String title,
    int releaseYear,
    String genre
) {
    public static BookResponse from(Book book){
        return new BookResponse(
           book.getId(),
           book.getTitle(),
           book.getReleaseyear(),
           book.getGenre()
        );
    }
}
