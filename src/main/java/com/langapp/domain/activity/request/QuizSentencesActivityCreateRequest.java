package com.langapp.domain.activity.request;

import lombok.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class QuizSentencesActivityCreateRequest {
    private UUID lessonId;
    private int order;
    private List<UUID> sentenceIds;
}
