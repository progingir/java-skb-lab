package com.example.demo.repository;

import com.example.demo.model.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TodoListRepository extends JpaRepository<TodoList, Long> {

    @Query("SELECT t FROM TodoList t LEFT JOIN FETCH t.events")
    List<TodoList> findAllWithEvents();
}