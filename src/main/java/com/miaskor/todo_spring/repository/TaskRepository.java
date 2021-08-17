package com.miaskor.todo_spring.repository;

import com.miaskor.todo_spring.model.Task;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface TaskRepository extends CrudRepository<Task,Integer> {
    List<Task> findByDateBetweenAndClientId(LocalDate from, LocalDate to, Integer clientId);
}
