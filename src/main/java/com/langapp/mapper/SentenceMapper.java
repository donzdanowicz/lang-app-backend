package com.langapp.mapper;

import com.langapp.domain.sentence.Sentence;
import com.langapp.domain.sentence.dto.SentenceDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SentenceMapper {

    public Sentence mapToSentence(final SentenceDto sentenceDto) {
        return Sentence.builder()
                .id(sentenceDto.getId())
                .content(sentenceDto.getContent())
                .build();
    }

    public SentenceDto mapToSentenceDto(final Sentence sentence) {
        return SentenceDto.builder()
                .id(sentence.getId())
                .content(sentence.getContent())
                .build();
    }

    public List<SentenceDto>  mapToSentenceDtoList(final List<Sentence> sentences) {
        return sentences.stream()
                .map(this::mapToSentenceDto)
                .collect(Collectors.toList());
    }
}
