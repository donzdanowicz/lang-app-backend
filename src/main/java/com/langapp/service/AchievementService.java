package com.langapp.service;

import com.langapp.domain.achievement.Achievement;
import com.langapp.domain.achievement.dto.AchievementDto;
import com.langapp.domain.user.User;
import com.langapp.exception.UserNotFoundException;
import com.langapp.mapper.AchievementMapper;
import com.langapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AchievementService {

    private final AchievementDbService dbService;
    private final AchievementMapper mapper;
    private final UserRepository userRepository;

    public Achievement createAchievement(AchievementDto dto) throws UserNotFoundException {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(UserNotFoundException::new);

        Achievement achievement = mapper.mapToAchievement(dto, user);

        return dbService.saveAchievement(achievement);
    }
}
