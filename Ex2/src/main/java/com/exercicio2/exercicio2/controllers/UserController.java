package com.exercicio2.exercicio2.controllers;


import com.exercicio2.exercicio2.models.Email;
import com.exercicio2.exercicio2.models.User;
import com.exercicio2.exercicio2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("user")
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("user/{id}")
    public Optional<User> find(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @PutMapping("user")
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    // DELETE - HTTP DELETE
    @DeleteMapping("user/{id}")
    public String delete(@PathVariable("id") Long id) {
        return userService.delete(id);
    }
}
