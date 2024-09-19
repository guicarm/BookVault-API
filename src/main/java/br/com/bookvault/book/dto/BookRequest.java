package br.com.bookvault.book.dto;

import br.com.bookvault.book.Book;

public record BookRequest (
    String title,
    int releaseYear,
    String genre
) {
    public Book toModel() {
        return Book.builder()
            .title(title)
            .releaseYear(releaseYear)
            .genre(genre)
            .build();
    }
}
