package com.project.questapp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
    private Long postId;
    private Long userId;
    @Lob
    @Column(columnDefinition = "text")
    String text;
}
