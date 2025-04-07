package com.example.demo.service;

import com.example.demo.dto.TodoListDto;
import com.example.demo.model.Event;
import com.example.demo.model.TodoList;
import com.example.demo.repository.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoListService {

    @Autowired
    private TodoListRepository todoListRepository;

    public TodoList createTodoList(TodoListDto dto) {
        TodoList todoList = new TodoList();
        todoList.setName(dto.name());

        List<Event> events = dto.events().stream()
                .map(title -> new Event(title, todoList))
                .collect(Collectors.toList());
        todoList.setEvents(events);

        return todoListRepository.save(todoList);
    }

    public List<TodoList> getAllTodoLists() {
        return todoListRepository.findAll();
    }
}