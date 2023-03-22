package com.iftm.firststructure.repositories;

import com.iftm.firststructure.models.Person;
import org.hibernate.annotations.Comment;
import org.springframework.core.annotation.AliasFor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
}
