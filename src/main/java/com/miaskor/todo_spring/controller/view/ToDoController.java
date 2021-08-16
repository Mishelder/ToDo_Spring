package com.miaskor.todo_spring.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ToDoController {
    @GetMapping("/todo")
    public String getToDo(){
        return "todo";
    }
}
