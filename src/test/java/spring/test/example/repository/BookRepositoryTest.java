package spring.test.example.repository;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import spring.test.example.model.Book;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource("classpath:data_test.properties")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void findById(){
        Book book = bookRepository.save(Book.builder()
        .title("Himar@")
        .description("1990tvakani girq")
        .build());
        Optional<Book> byId = bookRepository.findById(book.getId());
        assertTrue(byId.isPresent());
        assertEquals("Himar@",book.getTitle());
    }
}
