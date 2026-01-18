package com.langapp.service;

import com.langapp.domain.text.Text;
import com.langapp.repository.TextRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class TextDbService {
    private final TextRepository repository;

    public List<Text> getTexts() {
        return repository.findAll();
    }

    public Optional<Text> getText(final UUID id) {
        return repository.findById(id);
    }

    public Text saveText(final Text text) {
        return repository.save(text);
    }

    public void deleteText(final UUID id) {
        repository.deleteById(id);
    }
}
