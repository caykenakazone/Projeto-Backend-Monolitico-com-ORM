package com.exercicio2.exercicio2.services;

import com.exercicio2.exercicio2.models.Email;
import com.exercicio2.exercicio2.repositories.EmailRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
@Service
public class EmailService {
    @Autowired
    private EmailRepositories emailRepositories;

    public Optional<Email> findById(Long id) {
        return emailRepositories.findById(id);
    }

    public Email save(Email email) {if(!email.getFrom().isBlank() && !email.getTo().isEmpty() && !email.getSubject().isEmpty() && !email.getBody().isEmpty() && !email.getAttachment().isEmpty()){
            return emailRepositories.save(email);
        }
        return null;
    }

    public Email update(Email email) {
        var dbEmail = emailRepositories.findById(email.getId());
        if(dbEmail.isPresent()) {
            return emailRepositories.save(email);
        }
        return null;
    }

    public String delete(Long id) {
        var dbEmail = emailRepositories.findById(id);
        if(dbEmail.isPresent()) {
            emailRepositories.deleteById(id);
            return "Person id " + id + " has been deleted!";
        }else
            return "ID " + id + " not found!";
    }
}
