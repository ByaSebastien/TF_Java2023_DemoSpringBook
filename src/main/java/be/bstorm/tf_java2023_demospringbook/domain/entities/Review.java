package be.bstorm.tf_java2023_demospringbook.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id", nullable = false)
    private Long id;

    @Column(name = "review_rating", nullable = false)
    private int rating;

    @Column(name = "review_comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "review_book_id", nullable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "review_user_id", nullable = false)
    private User writtenBy;
}
