package com.langapp.facade;

import com.langapp.domain.activity.Activity;
import com.langapp.domain.activity.dto.ActivityDto;
import com.langapp.domain.activity.request.*;
import com.langapp.exception.*;
import com.langapp.mapper.activity.ActivityMapper;
import com.langapp.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class ActivityFacade {
    private final ActivityService service;
    private final ActivityMapper mapper;

    public ActivityDto createListeningActivity(ListeningActivityCreateRequest request) throws LessonNotFoundException, TextNotFoundException {
        return mapper.mapToActivityDto(service.createListeningActivity(request));
    }

    public ActivityDto createMemoryActivity(MemoryActivityCreateRequest request) throws LessonNotFoundException, WordNotFoundException {
        return mapper.mapToActivityDto(service.createMemoryActivity(request));
    }

    public ActivityDto createQuizSentencesActivity(QuizSentencesActivityCreateRequest request) throws LessonNotFoundException, SentenceNotFoundException {
        return mapper.mapToActivityDto(service.createQuizSentencesActivity(request));
    }

    public ActivityDto createQuizWordsActivity(QuizWordsActivityCreateRequest request) throws LessonNotFoundException, WordNotFoundException {
        return mapper.mapToActivityDto(service.createQuizWordsActivity(request));
    }

    public ActivityDto createReviewActivity(ReviewActivityCreateRequest request) throws LessonNotFoundException, WordNotFoundException {
        return mapper.mapToActivityDto(service.createReviewActivity(request));
    }

    public ActivityDto createTextActivity(TextActivityCreateRequest request) throws LessonNotFoundException, TextNotFoundException {
        return mapper.mapToActivityDto(service.createTextActivity(request));
    }

    public ActivityDto createWordsActivity(WordsActivityCreateRequest request) throws LessonNotFoundException, WordNotFoundException {
        return mapper.mapToActivityDto(service.createWordsActivity(request));
    }

    public ActivityDto getById(UUID id) throws ActivityNotFoundException {
        Activity activity = service.getActivity(id);
        return mapper.mapToActivityDto(activity);
    }

    public List<ActivityDto> getAll() {
        return mapper.mapToActivityDtoList(service.getActivities());
    }

    public void deleteById(UUID id) {
        service.deleteActivity(id);
    }

}
