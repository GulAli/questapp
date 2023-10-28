package com.project.questapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.questapp.entities.User;

/**********************************************
    -HINTS-
    1. Repositories help us send queries to database.
    For example, we have "findAll" method  inside
    of JpaRepository. This is a reflection of 
    "Select * from user" in PostgreSQL.

    Also see -> findById, delete, save, etc.
**********************************************/ 

public interface UserRepository extends JpaRepository<User, Long> {
    
}
