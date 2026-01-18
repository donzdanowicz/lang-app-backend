package com.langapp.mapper;

import com.langapp.domain.text.Text;
import com.langapp.domain.text.dto.TextDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TextMapper {

    public Text mapToText(final TextDto textDto) {
        return Text.builder()
                .id(textDto.getId())
                .title(textDto.getTitle())
                .content(textDto.getContent())
                .audioUrl(textDto.getAudioUrl())
                .build();
    }

    public TextDto mapToTextDto(final Text text) {
        return TextDto.builder()
                .id(text.getId())
                .title(text.getTitle())
                .content(text.getContent())
                .audioUrl(text.getAudioUrl())
                .build();
    }

    public List<TextDto> mapToTextDtoList(final List<Text> texts) {
        return texts.stream()
                .map(this::mapToTextDto)
                .collect(Collectors.toList());
    }
}
