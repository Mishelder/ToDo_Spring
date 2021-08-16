package com.miaskor.todo_spring.service;

import com.miaskor.todo_spring.model.Client;

public interface ClientService extends CrudService<Client,Integer> {
    Client findByLoginAndPassword(String login,String password);
    Client findByLogin(String login);
}
