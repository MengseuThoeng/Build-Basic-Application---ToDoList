package com.seu.todolist.controller;

import com.seu.todolist.model.Todo;
import com.seu.todolist.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;


@Controller
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @GetMapping("/todo")
    public String getAllTodoList(Model model){
        List<Todo> todoList = todoService.getAllTodoList();
        model.addAttribute("todos",todoList);
        return "index";
    }
    @GetMapping("/todo/create")
    public String createNew(Model model){
        Todo todos = new Todo();
        model.addAttribute("todos",todos);
        return "create";
    }
    @PostMapping("/create")
    public String submitCreate(@ModelAttribute("todos") Todo todo){
        todoService.addTodoList(todo);
        return "redirect:/todo";
    }
    @GetMapping("todo/delete/{id}")
    public String deleteTodo(@PathVariable("id") Integer id) {
        todoService.deleteTodoList(id);
        return "redirect:/todo";
    }
    @GetMapping("/todo/update/{id}")
    public String updateTodo(@PathVariable("id") Integer id,Model model){
        Todo foundTodo = todoService.findById(id);
        model.addAttribute("todos",foundTodo);
        return "update";
    }
    @PostMapping("/todo/update")
    public String submitUpdate(@ModelAttribute("todos") Todo todo){
        todoService.updateTodo(todo);
        System.out.println(todo);
        return "redirect:/todo";
    }
    @GetMapping("/todo/search")
    public String searchTodoList(@RequestParam(required = false) String task,
                                 @RequestParam(required = false) String isDone,
                                 Model model) {
        Boolean isDoneValue = null;
        if (isDone != null && !isDone.isEmpty()) {
            isDoneValue = Boolean.parseBoolean(isDone);
        }
        List<Todo> searchResult = todoService.searchTodos(task, isDoneValue);
        model.addAttribute("todos", searchResult);
        return "index";
    }




}
