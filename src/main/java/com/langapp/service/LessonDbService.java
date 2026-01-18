package com.langapp.service;

import com.langapp.domain.lesson.Lesson;
import com.langapp.repository.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class LessonDbService {
    private final LessonRepository repository;

    public List<Lesson> getLessons() {
        return repository.findAll();
    }

    public Optional<Lesson> getLesson(final UUID id) {
        return repository.findById(id);
    }

    public Lesson saveLesson(final Lesson lesson) {
        return repository.save(lesson);
    }

    public void deleteLesson(final UUID id) {
        repository.deleteById(id);
    }
}
