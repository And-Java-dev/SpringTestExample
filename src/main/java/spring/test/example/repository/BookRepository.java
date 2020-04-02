package spring.test.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.test.example.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
}
