package com.miaskor.todo_spring.controller.view;

import com.miaskor.todo_spring.exception.ClientEmailHasAlreadyExistException;
import com.miaskor.todo_spring.exception.ClientIsNotExistException;
import com.miaskor.todo_spring.exception.ClientLoginHasAlreadyExistException;
import com.miaskor.todo_spring.model.Client;
import com.miaskor.todo_spring.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class AuthorizationController {

    private final ClientService clientService;
    private final HttpSession httpSession;

    @Autowired
    public AuthorizationController(ClientService clientService, HttpSession httpSession) {
        this.clientService = clientService;
        this.httpSession = httpSession;
    }

    @PostMapping("/login")
    @Transactional(readOnly = true)
    public @ResponseBody Client loginClient(@RequestBody Client client){
        var byLogin = clientService.findByLogin(client.getLogin());
        if(byLogin.isEmpty())
            throw new ClientIsNotExistException("Client with login = "
                    + client.getLogin() + " hasn't found");
        var byLoginAndPassword = clientService
                .findByLoginAndPassword(client.getLogin(), client.getPassword());
        if(byLoginAndPassword.isEmpty())
            throw new ClientIsNotExistException("Client with password = "
                    + client.getPassword() + " hasn't found");
        httpSession.setAttribute("client",byLoginAndPassword.get());
        return byLoginAndPassword.get();
    }

    @PostMapping("/registration")
    @Transactional()
    public @ResponseBody Client registrationClient(@RequestBody Client client){
        var byLogin = clientService.findByLogin(client.getLogin());
        if(byLogin.isPresent())
            throw new ClientLoginHasAlreadyExistException("Client with login = "
                    + client.getLogin() + " has already exist");
        var byEmail = clientService.findByEmail(client.getEmail());
        if(byEmail.isPresent())
            throw new ClientEmailHasAlreadyExistException("Client with email = "
                    + client.getEmail() + " has already exist");
        var saveClient = clientService.save(client);
        httpSession.setAttribute("client",saveClient);
        return saveClient;
    }

    @GetMapping("/logout")
    public String loggedOut(){
        httpSession.invalidate();
        return "authorization";
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "authorization";
    }
}
