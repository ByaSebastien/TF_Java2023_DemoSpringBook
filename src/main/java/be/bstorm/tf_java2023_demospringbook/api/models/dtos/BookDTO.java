package be.bstorm.tf_java2023_demospringbook.api.models.dtos;

import be.bstorm.tf_java2023_demospringbook.domain.entities.Book;

import java.time.LocalDate;

public record BookDTO(
        Long id,
        String title,
        AuthorDTO author,
        LocalDate releaseDate) {

    public static BookDTO fromEntity(Book book){
        return new BookDTO(
                book.getId(),
                book.getTitle(),
                AuthorDTO.fromEntity(book.getAuthor()),
                book.getReleaseDate()
        );
    }
}
