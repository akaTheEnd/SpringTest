package com.example.demo.repository;

import com.example.demo.entity.TodoEntity;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<TodoEntity, Long> {
}
