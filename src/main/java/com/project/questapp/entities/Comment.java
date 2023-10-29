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
    1. By using "Lob" anotation,
    2. By using "Column" anotation, 

    3. In order to help Hibernate to understand string
    as text in PostgreSQL instead of varchar255, 
    we wrote "= text".

**********************************************/ 

@Entity
@Table(name="comment")
@Data
public class Comment {
    @Id
    private Long id;
    
    //private Long postId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="post_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    User post;
    
    //private Long userId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    User user;

    @Lob
    @Column(columnDefinition = "text")
    String text;
}
