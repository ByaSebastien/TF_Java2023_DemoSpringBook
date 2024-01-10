package be.bstorm.tf_java2023_demospringbook.dal.repositories;

import be.bstorm.tf_java2023_demospringbook.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
