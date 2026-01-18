package com.langapp.facade;

import com.langapp.domain.achievement.Achievement;
import com.langapp.domain.achievement.dto.AchievementDto;
import com.langapp.exception.AchievementNotFoundException;
import com.langapp.exception.UserNotFoundException;
import com.langapp.mapper.AchievementMapper;
import com.langapp.service.AchievementDbService;
import com.langapp.service.AchievementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class AchievementFacade {
    private final AchievementService service;
    private final AchievementDbService dbService;
    private final AchievementMapper mapper;

    public AchievementDto create(AchievementDto dto) throws UserNotFoundException {
        Achievement achievement = service.createAchievement(dto);
        return mapper.mapToAchievementDto(achievement);
    }

    public AchievementDto getById(UUID id) throws AchievementNotFoundException {
        Achievement achievement = dbService.getAchievement(id).orElseThrow(AchievementNotFoundException::new);
        return mapper.mapToAchievementDto(achievement);
    }

    public List<AchievementDto> getAll() {
        return mapper.mapToAchievementDtoList(dbService.getAchievements());
    }

    public void deleteById(UUID id) throws AchievementNotFoundException {
        dbService.deleteAchievement(id);
    }
}
