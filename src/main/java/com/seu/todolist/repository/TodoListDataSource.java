package com.seu.todolist.repository;

import com.seu.todolist.model.Todo;
import lombok.Getter;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
public class TodoListDataSource {
    private List<Todo> todos = new ArrayList<>();
    public TodoListDataSource(){
        todos.add(new Todo(1,"Run","Run to riverside",false, LocalDate.now()));
        todos.add(new Todo(2,"Study Sch","Go to CSTAD",false, LocalDate.now()));
        todos.add(new Todo(3,"Study Uni","Go to SETEC",false, LocalDate.now()));
        todos.add(new Todo(4,"Eat Dinner","With Honey",false, LocalDate.now()));
        todos.add(new Todo(5,"Assignment NextJS","CSTAD",true, LocalDate.now()));
    }
    //Todo(id, task, description, isDone, createdAt)

}
