package be.bstorm.tf_java2023_demospringbook.api.models.forms;

import be.bstorm.tf_java2023_demospringbook.api.validation.constraint.Censored;
import be.bstorm.tf_java2023_demospringbook.domain.entities.Book;
import be.bstorm.tf_java2023_demospringbook.domain.entities.Review;
import be.bstorm.tf_java2023_demospringbook.domain.entities.User;
import jakarta.validation.constraints.*;

public record ReviewForm(
        @NotNull
        @Min(0) @Max(5)
        Integer rating,
        @Censored(words = { "bien" })
        @Size(min = 20, max = 200)
        String comment,
        @NotNull
        Long bookId,
        @NotNull
        Long userId
) {
        public Review toEntity(){
                Review review = new Review();

                Book book = new Book();
                book.setId(bookId);
                User user = new User();
                user.setId(userId);

                review.setRating(rating);
                review.setComment(comment);
                review.setBook(book);
                review.setWrittenBy(user);

                return review;
        }
}
