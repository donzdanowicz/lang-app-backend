package com.langapp.service;

import com.langapp.domain.sentence.Sentence;
import com.langapp.repository.SentenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class SentenceDbService {
    private final SentenceRepository repository;

    public List<Sentence> getSentences(){
        return repository.findAll();
    }

    public Optional<Sentence> getSentence(final UUID id) {
        return repository.findById(id);
    }

    public Sentence saveSentence(final Sentence sentence) {
        return repository.save(sentence);
    }

    public void deleteSentence(final UUID id) {
        repository.deleteById(id);
    }


}
