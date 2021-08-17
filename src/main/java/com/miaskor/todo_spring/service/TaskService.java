package com.miaskor.todo_spring.service;

import com.miaskor.todo_spring.model.Task;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface TaskService extends CrudService<Task,Integer>{
    Map<LocalDate,List<Task>> findByDateBetweenAndClientId(LocalDate from, LocalDate to, Integer clientId);
}
