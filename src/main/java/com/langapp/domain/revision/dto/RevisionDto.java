package com.langapp.domain.revision.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RevisionDto {
    private UUID id;
    private int correctCount;
    private int incorrectCount;
    private LocalDateTime created;
    private LocalDateTime lastReviewed;
    private LocalDateTime nextReview;
    private UUID wordId;
    private UUID userId;
}
