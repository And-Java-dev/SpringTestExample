package spring.test.example.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import spring.test.example.model.Book;
import spring.test.example.repository.BookRepository;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTest {

    @MockBean
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    @Test
    public void delete(){
        int id = 71;
//        Book book = Book.builder()
//                .title("Himar@")
//                .description("1990tvakani girq e")
//                .build();
//        when(bookRepository.findById(id)).thenReturn(Optional.of(book));
         bookService.deleteById(id);
         verify(bookRepository).deleteById(id);
    }

    @Test
    public void findById() {
        int id = 1;
        Book  book = Book.builder()
                .title("Himar@")
                .description("1990tvakani girq")
                .build();
        when(bookRepository.findById(id)).thenReturn(Optional.of(book));
        Optional<Book> byId = bookService.getById(id);
        assertTrue(byId.isPresent());
        assertEquals(book.getTitle(),byId.get().getTitle());
    }

}
