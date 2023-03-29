package com.exercicio2.exercicio2.controllers;


import com.exercicio2.exercicio2.models.Email;
import com.exercicio2.exercicio2.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("email")
    public Email save(@RequestBody Email email) {
        return emailService.save(email);
    }

    @GetMapping("email/{id}")
    public Optional<Email> find(@PathVariable("id") Long id) {
        return emailService.findById(id);
    }

    @PutMapping("email")
    public Email update(@RequestBody Email email) {
        return emailService.update(email);
    }

    // DELETE - HTTP DELETE
    @DeleteMapping("email/{id}")
    public String delete(@PathVariable("id") Long id) {
        return emailService.delete(id);
    }
}


