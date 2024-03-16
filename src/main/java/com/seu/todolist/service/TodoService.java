package com.seu.todolist.service;

import com.seu.todolist.model.Todo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TodoService {
    List<Todo> getAllTodoList();
    void addTodoList(Todo todo);
    void deleteTodoList(Integer id);
    void updateTodo(Todo todo);
    Todo findById(Integer id);
    List<Todo> searchTodos(String task, Boolean isDone);
}
