package com.langapp.service;

import com.langapp.domain.category.Category;
import com.langapp.domain.word.Word;
import com.langapp.domain.word.dto.WordDto;
import com.langapp.exception.CategoryNotFoundException;
import com.langapp.mapper.WordMapper;
import com.langapp.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class WordService {

    private final WordDbService dbService;
    private final WordMapper mapper;
    private final CategoryRepository categoryRepository;

    public Word createWord(WordDto dto) throws CategoryNotFoundException {
        Category category = categoryRepository.findById(dto.getCategoryId()).orElseThrow(CategoryNotFoundException::new);

        Word word = mapper.mapToWord(dto, category);

        return dbService.saveWord(word);
    }
}
