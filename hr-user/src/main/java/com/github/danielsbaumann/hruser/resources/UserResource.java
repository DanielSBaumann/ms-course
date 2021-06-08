package com.github.danielsbaumann.hruser.resources;

import com.github.danielsbaumann.hruser.entities.User;
import com.github.danielsbaumann.hruser.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User user = userRepository
                .findById(id)
                .get();
        return ok(user);
    }

    @GetMapping(value = "search")
    public ResponseEntity<User> findByEmail(@RequestParam String email) {
        User user = userRepository
                .findByEmail(email);
        return ok(user);
    }
}
