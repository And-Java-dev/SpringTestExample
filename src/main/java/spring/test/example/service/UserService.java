package spring.test.example.service;

import spring.test.example.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> findById(int id);

    List<User> findAll();
}
