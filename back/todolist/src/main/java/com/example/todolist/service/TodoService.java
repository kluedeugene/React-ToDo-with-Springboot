package com.example.todolist.service;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.example.todolist.domain.Todo;

public interface TodoService {

    List<Todo> getTodos(Sort sort) throws Exception;

    void postTodo(Todo todo) throws Exception;

    void deleteTodo(Long id) throws Exception;

    Todo findTodoById(Long Id) throws Exception;
}

// Line 11 : Sort 를 파라미터로 가지며, Sort 를 통해 Todo 목록을 정렬하여 가져온다.
// Line 13 : Todo 를 추가 및 수정한다.
// Line 15 : Id 에 해당하는 Todo 를 삭제한다.
// Line 17 : Id 에 해당하는 Todo 를 조회한다.