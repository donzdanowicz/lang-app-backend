package com.langapp.service;

import com.langapp.domain.word.Word;
import com.langapp.repository.WordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class WordDbService {
    private final WordRepository repository;

    public List<Word> getWords() {
        return repository.findAll();
    }

    public Optional<Word> getWord(final UUID id) {
        return repository.findById(id);
    }

    public Word saveWord(final Word word) {
        return repository.save(word);
    }

    public void deleteWord(final UUID id) {
        repository.deleteById(id);
    }
}
