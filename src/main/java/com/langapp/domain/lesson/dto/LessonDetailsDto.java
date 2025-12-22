package com.langapp.domain.lesson.dto;

import com.langapp.common.Level;
import com.langapp.domain.word.dto.WordDto;
import com.langapp.domain.activity.dto.ActivityDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LessonDetailsDto {
    private UUID id;
    private String title;
    private String description;
    private Level level;
    private List<WordDto> newWords;
    private List<ActivityDto> activities;
}


