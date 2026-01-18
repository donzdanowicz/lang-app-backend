package com.langapp.repository;

import com.langapp.domain.revision.Revision;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Transactional
@Repository
public interface RevisionRepository extends CrudRepository<Revision, UUID> {
    @Override
    List<Revision> findAll();

    @Override
    Optional<Revision> findById(UUID id);

    @Override
    Revision save(Revision revision);

    @Override
    void deleteById(UUID id);
}
