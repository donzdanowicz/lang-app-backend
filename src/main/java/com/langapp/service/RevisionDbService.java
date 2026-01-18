package com.langapp.service;

import com.langapp.domain.revision.Revision;
import com.langapp.repository.RevisionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class RevisionDbService {
    private final RevisionRepository repository;

    public List<Revision> getRevisions() {
        return repository.findAll();
    }

    public Optional<Revision> getRevision(final UUID id) {
        return repository.findById(id);
    }

    public Revision saveRevision(final Revision revision) {
        return repository.save(revision);
    }

    public void deleteRevision(final UUID id) {
        repository.deleteById(id);
    }
}
