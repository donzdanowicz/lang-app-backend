package com.langapp.domain.lesson.dto;

import com.langapp.common.Level;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LessonDto {
    private UUID id;
    private String title;
    private String description;
    private Level level;
}
