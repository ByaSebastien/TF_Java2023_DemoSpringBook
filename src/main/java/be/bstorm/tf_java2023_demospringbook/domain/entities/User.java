package be.bstorm.tf_java2023_demospringbook.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "\"user\"")
@Getter @Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long id;

    @Column(name = "user_username", nullable = false, unique = true, updatable = false)
    private String username;

    @Column(name = "user_password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "writtenBy")
    private List<Review> reviews;

}
