package com.dmsh.otus.dockerlesson.controller;

import com.dmsh.otus.dockerlesson.dao.UserDao;
import com.dmsh.otus.dockerlesson.model.Error;
import com.dmsh.otus.dockerlesson.model.User;
import com.dmsh.otus.dockerlesson.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.message.StringFormattedMessage;
import org.apache.logging.log4j.message.StringFormatterMessageFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/api/v1/users")
@Slf4j
public class UserController {

    UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity getUserById(@PathVariable Long id) {
        Optional<User> user = service.findById(id);

        if(!user.isPresent()) {
            String message = "User with id: "+id+" is not found!";
            log.error(message);
            return ResponseEntity.badRequest().body(Error.builder().code("404").message(message).build());
        }

        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = service.findAll();
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = service.save(user);

        return ResponseEntity.ok(createdUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity saveUser(@RequestBody User user, @PathVariable Long id) {
        if(!service.findById(id).isPresent()) {
            String message = "User with id: "+id+" is not found!";
            log.error(message);
            return ResponseEntity.badRequest().body(Error.builder().code("404").message(message).build());
        }
        User savedUser = service.save(user);
        return ResponseEntity.ok(savedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        if(!service.findById(id).isPresent()) {
            String message = "User with id: "+id+" is not found!";
            log.error(message);
            return ResponseEntity.badRequest().body(Error.builder().code("404").message(message).build());
        }

        service.deleteById(id);

        return ResponseEntity.ok().build();
    }


}
