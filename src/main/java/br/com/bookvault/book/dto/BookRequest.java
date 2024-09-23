package br.com.bookvault.book.dto;

import br.com.bookvault.book.Book;

public record BookRequest (
    String title,
    int releaseyear,
    String genre
) {
    public Book toModel() {
        return Book.builder()
            .title(title)
            .releaseyear(releaseyear)
            .genre(genre)
            .build();
    }
}
