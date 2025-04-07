package com.example.demo.controller;

import com.example.demo.dto.TodoListDto;
import com.example.demo.model.TodoList;
import com.example.demo.service.TodoListService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    private TodoListService todoListService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TodoList createTodoList(@Valid @RequestBody TodoListDto todoListDto) {
        return todoListService.createTodoList(todoListDto);
    }

    @GetMapping
    public List<TodoList> getAllTodoLists() {
        return todoListService.getAllTodoLists();
    }
}