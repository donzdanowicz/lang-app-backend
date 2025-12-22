package com.langapp.domain.activity.dto;

import com.langapp.domain.sentence.dto.SentenceDto;
import lombok.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class QuizSentencesActivityDto extends ActivityDto {
    private List<SentenceDto> sentences;
}
