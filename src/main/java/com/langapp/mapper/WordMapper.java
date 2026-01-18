package com.langapp.mapper;

import com.langapp.domain.category.Category;
import com.langapp.domain.word.Word;
import com.langapp.domain.word.dto.WordDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class WordMapper {

    public Word mapToWord(final WordDto wordDto, final Category category) {
        return Word.builder()
                .id(wordDto.getId())
                .word(wordDto.getWord())
                .translation(wordDto.getTranslation())
                .imageUrl(wordDto.getImageUrl())
                .audioUrl(wordDto.getAudioUrl())
                .level(wordDto.getLevel())
                .category(category)
                .build();
    }

    public WordDto mapToWordDto(final Word word) {
        return WordDto.builder()
                .id(word.getId())
                .word(word.getWord())
                .translation(word.getTranslation())
                .imageUrl(word.getImageUrl())
                .audioUrl(word.getAudioUrl())
                .level(word.getLevel())
                .categoryId(word.getCategory().getId())
                .build();
    }

    public List<WordDto> mapToWordDtoList(final List<Word> words) {
        return words.stream()
                .map(this::mapToWordDto)
                .collect(Collectors.toList());
    }
}
