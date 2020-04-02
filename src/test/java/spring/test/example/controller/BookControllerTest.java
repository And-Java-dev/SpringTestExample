package spring.test.example.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import spring.test.example.model.Book;
import spring.test.example.service.BookService;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.mock.web.MockRequestDispatcher.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTest {

    @MockBean
    private BookService bookService;

    @Autowired
    private MockMvc mvc;

    @Test
    public void findById () throws Exception {
        int id =1;
        Book book = Book.builder()
                .title("Himar@")
                .description("1990tvakani girq")
                .build();
        when(bookService.getById(id)).thenReturn(Optional.of(book));
        mvc.perform(get("/books/" + id))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value(book.getTitle()))
                .andExpect(jsonPath("$.description").value(book.getDescription()));
    }


}
