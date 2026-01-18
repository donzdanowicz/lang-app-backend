package com.langapp.repository;

import com.langapp.domain.lesson.Lesson;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Transactional
@Repository
public interface LessonRepository extends CrudRepository<Lesson, UUID> {
    @Override
    List<Lesson> findAll();

    @Override
    Optional<Lesson> findById(UUID id);

    @Override
    Lesson save(Lesson lesson);

    @Override
    void deleteById(UUID id);


}
