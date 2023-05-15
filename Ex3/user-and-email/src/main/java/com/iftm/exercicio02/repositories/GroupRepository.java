package com.iftm.exercicio02.repositories;


import com.iftm.exercicio02.models.Group;
import com.iftm.exercicio02.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    @Query("SELECT g.users FROM Group g WHERE g.id = :groupId")
    List<User> findUsersByGroupId(Long groupId);

    List<Group> findByNameContaining(String pwd);
}
