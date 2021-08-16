package com.miaskor.todo_spring.service;

import com.miaskor.todo_spring.model.Task;
import com.miaskor.todo_spring.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

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
}
