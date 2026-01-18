package com.langapp.mapper;

import com.langapp.domain.achievement.Achievement;
import com.langapp.domain.achievement.dto.AchievementDto;
import com.langapp.domain.user.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AchievementMapper {

    public Achievement mapToAchievement(final AchievementDto achievementDto, final User user) {
        return Achievement.builder()
                .id(achievementDto.getId())
                .name(achievementDto.getName())
                .description(achievementDto.getDescription())
                .imageUrl(achievementDto.getImageUrl())
                .unlockedAt(achievementDto.getUnlockedAt())
                .user(user)
                .build();
    }

    public AchievementDto mapToAchievementDto(final Achievement achievement) {
        return AchievementDto.builder()
                .id(achievement.getId())
                .name(achievement.getName())
                .description(achievement.getDescription())
                .imageUrl(achievement.getImageUrl())
                .unlockedAt(achievement.getUnlockedAt())
                .userId(achievement.getUser().getId())
                .build();
    }

    public List<AchievementDto> mapToAchievementDtoList(final List<Achievement> achievements) {
        return achievements.stream()
                .map(this::mapToAchievementDto)
                .collect(Collectors.toList());
    }
}
