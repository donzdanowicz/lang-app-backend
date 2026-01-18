package com.langapp.mapper;

import com.langapp.domain.lesson.Lesson;
import com.langapp.domain.lesson.dto.LessonDetailsDto;
import com.langapp.domain.lesson.dto.LessonDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LessonMapper {

    public Lesson mapToLesson(final LessonDto lessonDto) {
        return Lesson.builder()
                .id(lessonDto.getId())
                .title(lessonDto.getTitle())
                .description(lessonDto.getDescription())
                .level(lessonDto.getLevel())
                .build();
    }

    public LessonDto mapToLessonDto(final Lesson lesson) {
        return LessonDto.builder()
                .id(lesson.getId())
                .title(lesson.getTitle())
                .description(lesson.getDescription())
                .level(lesson.getLevel())
                .build();
    }

    public List<LessonDto> mapToLessonDtoList(final List<Lesson> lessons) {
        return lessons.stream()
                .map(this::mapToLessonDto)
                .collect(Collectors.toList());
    }

    public LessonDetailsDto mapToLessonDetailsDto(final Lesson lesson) {
        return LessonDetailsDto.builder().build(); //TODO
    }
}
