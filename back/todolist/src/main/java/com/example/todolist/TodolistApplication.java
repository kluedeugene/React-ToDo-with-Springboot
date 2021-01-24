package com.example.todolist;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.todolist.domain.Todo;
import com.example.todolist.repository.TodoRepository;

@SpringBootApplication
public class TodolistApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(TodoRepository todoRepository) throws Exception {
		return (args) -> {
			IntStream.rangeClosed(1, 10).forEach(index -> todoRepository.save(Todo.builder().content("오늘 할 일" + index)
					.createdDateTime(LocalDateTime.now()).isComplete(false).build()));
		};
	}
}
/*
 * Line 21 : 스프링은 빈(Bean) 으로 생성된 메서드에 파라미터로 DI(Dependency Injection, 스프링의 주요 특성
 * 중 하나로 주로 의존 관계 주입이라고 한다. 또는 의존 관계를 주입하는게 아니라 단지 객체의 레퍼런스를 전달하여 참조시킨다는 의미로 의존
 * 관계 설정이 라고도 한다) 시키는 메커니즘이 존재한다. 생성자를 통해 의존성을 주입시키는 방법과 유사하다. 이를 이용하여
 * CommandLineRunner 를 빈으로 등록한 후 TodoRepository 를 주입받는다.
 * 
 * Line 23 : 자바 8 람다 표현식을 사용하여 깔끔하게 코드를 구현하였다.
 * 
 * Line 24 : 페이징 처리 테스트를 위해서 Todo 객체를 빌더 패턴(Builder Pattern, 객체의 생성 과정과 표현 방법을
 * 분리하여 객체를 단계별 동일한 생성 절차로 복잡한 객체로 만드는 패턴)을 사용하여 생성한 후 주입받은 TodoRepository 를
 * 사용하여 Todo 객체를 저장한다. 이때 IntStream 의 rangeClosed 를 사용하여 index 순서대로 Todo 객체 10개를
 * 생성하여 저장한다.
 * 
 * 
 * http://localhost:8080/api/todos
 */