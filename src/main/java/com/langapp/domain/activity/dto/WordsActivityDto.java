package com.langapp.domain.activity.dto;

import com.langapp.domain.word.dto.WordDto;
import lombok.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class WordsActivityDto extends ActivityDto {
    private List<WordDto> words;
}
