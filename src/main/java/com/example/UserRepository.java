package com.example;


import java.util.List;
import java.util.Optional;

public interface UserRepository {

    User save(User user);

    Optional<User> findById(int id);

    Optional<User> findByEmail(String email);

    List<User> findAll();
}
