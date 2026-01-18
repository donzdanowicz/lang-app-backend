package com.langapp.repository;

import com.langapp.domain.user.User;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Transactional
@Repository
public interface UserRepository extends CrudRepository<User, UUID> {
    @Override
    List<User> findAll();

    @Override
    Optional<User> findById(UUID id);

    @Override
    User save(User user);

    @Override
    void deleteById(UUID id);
}
