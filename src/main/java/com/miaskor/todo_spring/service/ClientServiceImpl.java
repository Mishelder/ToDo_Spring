package com.miaskor.todo_spring.service;

import com.miaskor.todo_spring.exception.ClientIsNotExistException;
import com.miaskor.todo_spring.model.Client;
import com.miaskor.todo_spring.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    @Override
    public Set<Client> findAll() {
        Set<Client> clients = new HashSet<>();
        clientRepository.findAll().forEach(clients::add);
        return clients;
    }

    @Override
    public Client findById(Integer integer) {
        var clientById = clientRepository.findById(integer);
        if (clientById.isEmpty())
            throw new ClientIsNotExistException("Client with id = " + integer + " has not found");
        return clientById.get();
    }

    @Override
    public Client save(Client object) {
        return clientRepository.save(object);
    }

    @Override
    public void delete(Client object) {
        clientRepository.delete(object);
    }

    @Override
    public void deleteById(Integer integer) {
        var clientById = clientRepository.findById(integer);
        if (clientById.isEmpty())
            throw new ClientIsNotExistException("Client with id = " + integer + " has not been deleted");
        clientRepository.deleteById(integer);
    }
}
