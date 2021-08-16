package com.miaskor.todo_spring.repository;

import com.miaskor.todo_spring.model.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClientRepository extends CrudRepository<Client, Integer> {
    Optional<Client> findClientByLoginAndPassword(String login, String password);
    Optional<Client> findClientByLogin(String login);
}

