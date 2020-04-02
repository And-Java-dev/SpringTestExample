package spring.test.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.test.example.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity userById(@PathVariable("id")int id){
        return ResponseEntity.ok(userService.findById(id).get());
    }

    @GetMapping
    public ResponseEntity allUsers(){
        return ResponseEntity.ok(userService.findAll());
    }
}
