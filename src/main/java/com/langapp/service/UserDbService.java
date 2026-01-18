package com.langapp.service;

import com.langapp.domain.user.User;
import com.langapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserDbService {
    private final UserRepository repository;

    public List<User> getUsers() {
        return repository.findAll();
    }

    public Optional<User> getUser(final UUID id) {
        return repository.findById(id);
    }

    public User saveUser(final User user) {
        return repository.save(user);
    }

    public void deleteUser(final UUID id) {
        repository.deleteById(id);
    }
}
