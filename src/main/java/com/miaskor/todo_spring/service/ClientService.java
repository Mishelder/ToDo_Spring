package com.miaskor.todo_spring.service;

import com.miaskor.todo_spring.model.Client;

import java.util.Optional;

public interface ClientService extends CrudService<Client, Integer> {
    Optional<Client> findByLoginAndPassword(String login, String password);
    Optional<Client> findByLogin(String login);
    Optional<Client> findByEmail(String email);
}
