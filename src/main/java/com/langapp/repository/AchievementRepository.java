package com.langapp.repository;

import com.langapp.domain.achievement.Achievement;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Transactional
@Repository
public interface AchievementRepository extends CrudRepository<Achievement, UUID> {

    @Override
    List<Achievement> findAll();

    @Override
    Optional<Achievement> findById(UUID id);

    @Override
    Achievement save(Achievement achievement);

    @Override
    void deleteById(UUID id);
}
