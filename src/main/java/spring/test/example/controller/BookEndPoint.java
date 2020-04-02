package spring.test.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.test.example.service.BookService;

@RestController
@RequestMapping("/books")
public class BookEndPoint {

    private final BookService bookService;

    public BookEndPoint(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public ResponseEntity getBook(@PathVariable("id") int id){
        return ResponseEntity.ok(bookService.getById(id));

    }

    @GetMapping
    public ResponseEntity allBooks(){
        return ResponseEntity.ok(bookService.allBooks());
    }

    @DeleteMapping("?{id}")
    public ResponseEntity delete(@PathVariable("id") int id) {
        bookService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
