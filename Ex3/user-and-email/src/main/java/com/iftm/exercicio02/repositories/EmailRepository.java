package com.iftm.exercicio02.repositories;

import com.iftm.exercicio02.models.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {

    List<Email> findByUserId(Long userId);

}

