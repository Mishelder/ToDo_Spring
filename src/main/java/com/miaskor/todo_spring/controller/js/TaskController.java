package com.miaskor.todo_spring.controller.js;

import com.miaskor.todo_spring.model.Client;
import com.miaskor.todo_spring.model.DateRange;
import com.miaskor.todo_spring.model.Task;
import com.miaskor.todo_spring.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController(value = "taskJsController")
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;
    private final HttpSession httpSession;

    @Autowired
    public TaskController(TaskService taskService, HttpSession httpSession) {
        this.taskService = taskService;
        this.httpSession = httpSession;
    }

    @PostMapping("/save")
    public Task saveTask(@RequestBody Task task){
        var clientId = ((Client) httpSession.getAttribute("client")).getId();
        task.setClientId(clientId);
        return taskService.save(task);
    }

    @PostMapping("/range")
    public @ResponseBody Map<LocalDate, List<Task>> addTask(@RequestBody DateRange range){
        var clientId =((Client) httpSession.getAttribute("client")).getId();
        return taskService.findByDateBetweenAndClientId(range.getFrom(), range.getTo(), clientId);
    }

    @PutMapping("/update")
    public Task updateTask(@RequestBody Task task){
        var clientId =((Client) httpSession.getAttribute("client")).getId();
        task.setClientId(clientId);
        return taskService.save(task);
    }
}
