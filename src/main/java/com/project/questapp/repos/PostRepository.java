package com.project.questapp.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.questapp.entities.Post;

/**********************************************
    -HINTS-
    1. "findBy..." is constant. Methods that start
    with "findBy" is mapped to related methods in
    JpaRepository interface.
**********************************************/ 

public interface PostRepository extends JpaRepository<Post, Long>{

    List<Post> findByUserId(Long userId);
    
}
