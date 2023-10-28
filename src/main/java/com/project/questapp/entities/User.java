package com.project.questapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**********************************************
    -HINTS-
    1. By using "Entity" anotation, we indicate that
    "User" class will be mapped to database.

    2. By using "Table" anotation, we indicate that
    a table named "user" will be created in our database.

    3. "id" varible is a must as we create a table in
    our database. That is why we use "Id" anotation. "id"
    helps us add/delete/update our members in our table.
    
    Example PostgreSQL table:
    
    postgres=# SELECT * FROM user;
    
    id |  name  | surname
    ----+--------+---------
      1 | John   | Doe
      2 | Jane   | Smith

    4. "Data" anotation is used getter and setter methods
    to automatically be written by Lombok dependency.

**********************************************/ 

@Entity
@Table(name="user_table")
@Data
public class User {
    @Id
    private Long id;
    private String userName;
    private String password;
}
