package com.langapp.mapper.activity;

import com.langapp.domain.activity.Activity;
import com.langapp.domain.activity.ActivityType;
import com.langapp.domain.activity.ListeningActivity;
import com.langapp.domain.activity.dto.ListeningActivityDto;
import com.langapp.mapper.TextMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ListeningActivityMapper implements SpecificActivityMapper<ListeningActivityDto> {

    private final TextMapper textMapper;

    @Override
    public ActivityType getActivityType() {
        return ActivityType.LISTENING;
    }

    @Override
    public ListeningActivityDto mapToDto(Activity activity) {
        ListeningActivity listeningActivity = activity.getListeningActivity();

        return ListeningActivityDto.builder()
                .id(activity.getId())
                .activityType(ActivityType.LISTENING)
                .order(activity.getOrder())
                .text(textMapper.mapToTextDto(listeningActivity.getText()))
                .build();
    }
}
