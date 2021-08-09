package com.miaskor.todo_spring.controller.rest;

import com.miaskor.todo_spring.model.Client;
import com.miaskor.todo_spring.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }


    @GetMapping("")
    public Set<Client> getAllClients(){
        return clientService.findAll();
    }

    @GetMapping("{id}")
    public Client getClientById(@PathVariable Integer id){
        return clientService.findById(id);
    }

    @PostMapping("")
    public Client addClient(@RequestBody Client client){
        return clientService.save(client);
    }

    @PutMapping("")
    public Client updateClient(@RequestBody Client client){
        return clientService.save(client);
    }

    @DeleteMapping("{id}")
    public void deleteClient(@PathVariable Integer id){
        clientService.deleteById(id);
    }
}
