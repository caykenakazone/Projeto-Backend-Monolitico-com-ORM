package com.iftm.exercicio02.repositories;

import com.iftm.exercicio02.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByFirstName(String firstName);

    @Query("SELECT u FROM User u WHERE u.firstName = :firstName AND u.lastName = :lastName AND u.userName = :userName")
    User findByFullNameAndUserName(String firstName, String lastName, String userName);
}

