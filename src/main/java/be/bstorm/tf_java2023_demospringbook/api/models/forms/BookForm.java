package be.bstorm.tf_java2023_demospringbook.api.models.forms;

import be.bstorm.tf_java2023_demospringbook.domain.entities.Book;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record BookForm(
        @NotBlank @Size(min = 1, max = 100)
        String title,
        @NotNull @Past
        LocalDate releaseDate,
        @Valid
        AuthorForm author
) {
    public Book toEntity(){
        return new Book(this.title,author.toEntity(),this.releaseDate);
    }
}
