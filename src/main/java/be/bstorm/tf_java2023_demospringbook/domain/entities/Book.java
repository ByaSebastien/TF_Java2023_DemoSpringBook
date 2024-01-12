package be.bstorm.tf_java2023_demospringbook.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 100)
    private String title;

    @ManyToOne
    private Author author;

    @OneToMany(mappedBy = "book")
    private List<Review> reviews;

//    @Temporal(TemporalType.DATE)
    @Column(name = "book_release_date", nullable = false)
    private LocalDate releaseDate;

    public Book(String title, Author author, LocalDate releaseDate) {
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
    }
}
