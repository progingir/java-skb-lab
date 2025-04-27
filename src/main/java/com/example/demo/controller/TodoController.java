package com.example.demo.controller;

import com.example.demo.dto.TodoListDto;
import com.example.demo.dto.TodoListResponseDto;
import com.example.demo.model.TodoList;
import com.example.demo.service.TodoListService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoListService todoListService;

    public TodoController(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TodoList createTodoList(@Valid @RequestBody TodoListDto todoListDto) {
        return todoListService.createTodoList(todoListDto);
    }

    @GetMapping
    public List<TodoListResponseDto> getAllTodoLists() {
        return todoListService.getAllTodoLists();
    }
}