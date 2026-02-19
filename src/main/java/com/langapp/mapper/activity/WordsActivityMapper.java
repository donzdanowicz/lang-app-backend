package com.langapp.mapper.activity;

import com.langapp.domain.activity.Activity;
import com.langapp.domain.activity.ActivityType;
import com.langapp.domain.activity.WordsActivity;
import com.langapp.domain.activity.dto.WordsActivityDto;
import com.langapp.mapper.WordMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class WordsActivityMapper implements SpecificActivityMapper<WordsActivityDto> {

    private final WordMapper wordMapper;

    @Override
    public ActivityType getActivityType() {
        return ActivityType.WORDS;
    }

    @Override
    public WordsActivityDto mapToDto(Activity activity) {
        WordsActivity wordsActivity = activity.getWordsActivity();

        return WordsActivityDto.builder()
                .id(activity.getId())
                .activityType(ActivityType.WORDS)
                .order(activity.getOrder())
                .words(wordMapper.mapToWordDtoList(wordsActivity.getWords()))
                .build();
    }
}
