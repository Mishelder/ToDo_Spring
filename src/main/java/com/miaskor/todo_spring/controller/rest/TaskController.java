package com.miaskor.todo_spring.controller.rest;

import com.miaskor.todo_spring.exception.TaskIsNotExistException;
import com.miaskor.todo_spring.model.Task;
import com.miaskor.todo_spring.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("")
    public Set<Task> getTasks(){
        return taskService.findAll();
    }

    @GetMapping("{id}")
    public Task getTaskById(@PathVariable Integer id){
        var byId = taskService.findById(id);
        if(byId.isEmpty())
            throw new TaskIsNotExistException("Task with id = " + id + " haven't found");
        return byId.get();
    }

    @PutMapping("")
    public Task updateTask(@RequestBody Task task){
        return taskService.save(task);
    }

    @DeleteMapping("{id}")
    public void deleteTask(@PathVariable Integer id){
        taskService.deleteById(id);
    }

    @PostMapping("")
    public Task addTask(@RequestBody Task task){
        return taskService.save(task);
    }

}
