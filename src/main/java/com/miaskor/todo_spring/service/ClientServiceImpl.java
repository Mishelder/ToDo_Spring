package com.miaskor.todo_spring.service;

import com.miaskor.todo_spring.model.Client;
import com.miaskor.todo_spring.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Set<Client> findAll() {
        Set<Client> clients = new HashSet<>();
        clientRepository.findAll().forEach(clients::add);
        return clients;
    }

    @Override
    public Optional<Client> findById(Integer integer) {
        return clientRepository.findById(integer);
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
        clientRepository.deleteById(integer);
    }

    @Override
    public Optional<Client> findByLoginAndPassword(String login, String password) {
        return clientRepository.findClientByLoginAndPassword(login, password);
    }

    @Override
    public Optional<Client> findByLogin(String login) {
        return clientRepository.findByLogin(login);
    }

    @Override
    public Optional<Client> findByEmail(String email) {
        return clientRepository.findByEmail(email);
    }
}
