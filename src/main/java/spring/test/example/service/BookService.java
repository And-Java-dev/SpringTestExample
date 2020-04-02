package spring.test.example.service;

import spring.test.example.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

     Optional<Book> getById(int id);
     List<Book> allBooks();
     void deleteById(int id);
}
