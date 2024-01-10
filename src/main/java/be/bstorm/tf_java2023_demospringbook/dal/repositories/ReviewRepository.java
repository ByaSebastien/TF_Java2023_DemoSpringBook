package be.bstorm.tf_java2023_demospringbook.dal.repositories;

import be.bstorm.tf_java2023_demospringbook.domain.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {

    boolean existsByBook_IdAndWrittenBy_Id(long bookId, long userId);
    boolean existsByIdNotAndBook_IdAndWrittenBy_Id(long id, long bookId, long userId);

}
