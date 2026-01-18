package com.langapp.repository;

import com.langapp.domain.category.Category;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Transactional
@Repository
public interface CategoryRepository extends CrudRepository<Category, UUID> {
    @Override
    List<Category> findAll();

    @Override
    Optional<Category> findById(UUID id);

    @Override
    Category save(Category category);

    @Override
    void deleteById(UUID id);
}
