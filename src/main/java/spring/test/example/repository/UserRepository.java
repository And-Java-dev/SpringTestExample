package spring.test.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.test.example.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {
}
