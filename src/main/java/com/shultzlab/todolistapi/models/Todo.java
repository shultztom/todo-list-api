package com.shultzlab.todolistapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@Entity
@Table
public class Todo {
    @Id
    @GeneratedValue(strategy=SEQUENCE)
    private Long id;
    private String name;
    private String owner;
    private Boolean completed;

}
