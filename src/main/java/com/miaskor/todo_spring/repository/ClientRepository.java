package com.miaskor.todo_spring.repository;

import com.miaskor.todo_spring.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Integer> {
}
