package com.miaskor.todo_spring.controller.view;

import com.miaskor.todo_spring.model.Client;
import com.miaskor.todo_spring.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthorizationController {

    private final ClientService clientService;

    @Autowired
    public AuthorizationController(ClientService clientService){
        this.clientService = clientService;
    }

    @PostMapping("/login")
    @Transactional(readOnly = true)
    public @ResponseBody Client loginClient(@RequestBody Client client){
        clientService.findByLogin(client.getLogin());
        return clientService.findByLoginAndPassword(client.getLogin(), client.getPassword());
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "authorization";
    }
}
