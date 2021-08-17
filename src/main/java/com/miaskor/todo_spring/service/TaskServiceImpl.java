package com.miaskor.todo_spring.service;

import com.miaskor.todo_spring.model.Task;
import com.miaskor.todo_spring.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Set<Task> findAll() {
        Set<Task> tasks = new HashSet<>();
        taskRepository.findAll().forEach(tasks::add);
        return tasks;
    }

    @Override
    public Optional<Task> findById(Integer integer) {
        return taskRepository.findById(integer);
    }

    @Override
    public Task save(Task object) {
        return taskRepository.save(object);
    }

    @Override
    public void delete(Task object) {
        taskRepository.delete(object);
    }

    @Override
    public void deleteById(Integer integer) {
        taskRepository.deleteById(integer);
    }

    @Override
    public Map<LocalDate,List<Task>> findByDateBetweenAndClientId(LocalDate from, LocalDate to, Integer clientId) {
        var listTask = taskRepository.findByDateBetweenAndClientId(from, to, clientId);
        Map<LocalDate,List<Task>> tasks = new HashMap<>();
        listTask.forEach(item->tasks.put(item.getDate()
                ,listTask.stream()
                        .filter(eqByDate-> eqByDate.getDate().equals(item.getDate()))
                        .collect(Collectors.toList())));
        return tasks;
    }
}
