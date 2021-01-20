package com.example.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todolist.domain.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}