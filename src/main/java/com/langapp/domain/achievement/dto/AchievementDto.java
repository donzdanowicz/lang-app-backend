package com.langapp.domain.achievement.dto;

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
public class AchievementDto {
    private UUID id;
    private String name;
    private String description;
    private String imageUrl;
    private LocalDateTime unlockedAt;
    private UUID userId;
}
