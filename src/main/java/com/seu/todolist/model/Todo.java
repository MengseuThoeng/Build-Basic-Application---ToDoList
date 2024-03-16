package com.seu.todolist.model;

import lombok.*;

import java.time.LocalDate;



@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter
public class Todo {
    private Integer id;
    private String task;
    private String description;
    private Boolean isDone;
    private LocalDate createAt;
}
