package com.langapp.repository;

import com.langapp.domain.activity.Activity;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Transactional
@Repository
public interface ActivityRepository extends CrudRepository<Activity, UUID> {

    @Override
    List<Activity> findAll();

    @Override
    Optional<Activity> findById(UUID id);

    @Override
    Activity save(Activity activity);

    @Override
    void deleteById(UUID id);
}
