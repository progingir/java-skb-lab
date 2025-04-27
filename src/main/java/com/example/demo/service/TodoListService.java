package com.example.demo.service;

import com.example.demo.dto.TodoListDto;
import com.example.demo.dto.TodoListResponseDto;
import com.example.demo.model.Event;
import com.example.demo.model.TodoList;
import com.example.demo.repository.TodoListRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoListService {

    private final TodoListRepository todoListRepository;

    public TodoListService(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Transactional
    public TodoList createTodoList(TodoListDto dto) {
        TodoList todoList = TodoList.builder()
                .name(dto.name())
                .build();

        List<Event> events = dto.events().stream()
                .map(title -> Event.builder()
                        .title(title)
                        .todoList(todoList)
                        .build())
                .collect(Collectors.toList());
        todoList.setEvents(events);

        return todoListRepository.save(todoList);
    }

    @Transactional(readOnly = true)
    public List<TodoListResponseDto> getAllTodoLists() {
        List<TodoList> todoLists = todoListRepository.findAllWithEvents();
        return todoLists.stream()
                .map(todoList -> new TodoListResponseDto(
                        todoList.getId(),
                        todoList.getName(),
                        todoList.getEvents().stream()
                                .map(Event::getTitle)
                                .collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }
}