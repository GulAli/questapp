package com.project.questapp.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

/**********************************************
    -HINTS-
    1. By using "ManyToOne" annotation, we indicate
    that we might have many posts of one user.
    For example:
        1 school, many lecturers -> For school entity
    relation is OneToMany.
    
    2. By using "(fetch = FetchType.LAZY)" we indicate
    taking a post without getting its user.
    Example:
        (fetch = FetchType.EAGER) -> Does the opposite.
    
    3. By using "JoinColumn", we indicate that we attached
    user_id to our user object.
    Example:
            postgres=# SELECT * FROM post;
             id | text | title | user_id
            ----+------+-------+---------

    4. By using "OnDelete", we indicate to do something
    in case of deletion.
    For example:
        if, (action = OnDeleteAction.CASCADE) -> 
        delete all posts of related user
    
    5. We use "JsonIgnore" annotation not to get in a trouble
    with serialization.


**********************************************/ 

@Entity
@Table(name="post")
@Data
public class Post {
    @Id
    private Long id;
    //private Long userId;    
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    User user;

    @Lob
    @Column(columnDefinition = "text")
    String text;
}
