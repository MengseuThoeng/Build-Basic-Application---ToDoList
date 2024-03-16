package com.seu.todolist.service;

import com.seu.todolist.model.Todo;
import com.seu.todolist.repository.TodoListDataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoServiceImp implements TodoService {
    private final TodoListDataSource todoListDataSource;
    @Override
    public List<Todo> getAllTodoList() {
        System.out.println(todoListDataSource.getTodos());
        return todoListDataSource.getTodos();
    }

    @Override
    public void addTodoList(Todo todo) {
        Todo lastTodos = new Todo();
        List<Todo> todoList = todoListDataSource.getTodos();
        if (!todoList.isEmpty()){
            lastTodos = todoList.get(todoList.size()-1);
        }
        todo.setId(lastTodos.getId()+1);
        todo.setCreateAt(LocalDate.now());
        System.out.println("Todos Size Before Adding: " + todoListDataSource.getTodos().size());
        todoListDataSource.getTodos().add(todo); // Assuming you have a getTodos method
        System.out.println("Todos Size After Adding: " + todoListDataSource.getTodos().size());

    }


    @Override
    public void deleteTodoList(Integer id) {
        List<Todo> todoList = todoListDataSource.getTodos();
        for (Todo todo:todoList){
            if(todo.getId().equals(id)){
                todoList.remove(todo);
                break;
            }
        }
    }

    @Override
    public void updateTodo(Todo todo) {
        todoListDataSource.getTodos().stream().filter(t->t.getId().equals(todo.getId()))
                .forEach(p-> {
                    p.setTask(todo.getTask());
                    p.setDescription(todo.getDescription());
                    p.setIsDone(todo.getIsDone());
                });
    }

    @Override
    public Todo findById(Integer id) {
        return todoListDataSource.getTodos()
                .stream()
                .filter(todo -> todo.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Todo> searchTodos(String task, Boolean isDone) {
        List<Todo> allTodos = todoListDataSource.getTodos(); // Always fetch the latest list
        return allTodos.stream()
                .filter(todo ->
                        (task == null || todo.getTask().toLowerCase().contains(task.toLowerCase())) &&
                                (isDone == null || todo.getIsDone().equals(isDone))
                )
                .collect(Collectors.toList());
    }
}
