package com.iftm.exercicio02.repositories;

import com.iftm.exercicio02.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByIdade(int idade);

    List<User> findByFirstNameAndLastName(String firstName, String lastName);
}
