package com.miaskor.todo_spring.repository;

import com.miaskor.todo_spring.model.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task,Integer> {
}
