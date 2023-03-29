package com.exercicio2.exercicio2.services;


import com.exercicio2.exercicio2.models.User;
import com.exercicio2.exercicio2.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepositories userRepositories;

    public Optional<User> findById(Long id) {
        return userRepositories.findById(id);
    }

    public User save(User user) {if(!user.getFirstName().isBlank() && !user.getLastName().isEmpty() && !user.getUserName().isEmpty() && !user.getPassword().isEmpty() && !user.getPhone().isEmpty()&& !user.getSocialNetwork().isEmpty()){
        return userRepositories.save(user);
    }
        return null;
    }

    public User update(User user) {
        var dbUser = userRepositories.findById(user.getId());
        if(dbUser.isPresent()) {
            return userRepositories.save(user);
        }
        return null;
    }

    public String delete(Long id) {
        var dbUser = userRepositories.findById(id);
        if(dbUser.isPresent()) {
            userRepositories.deleteById(id);
            return "User id " + id + " has been deleted!";
        }else
            return "ID " + id + " not found!";
    }
}
