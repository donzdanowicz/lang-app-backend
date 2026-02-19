package com.langapp.mapper.activity;

import com.langapp.domain.activity.Activity;
import com.langapp.domain.activity.ActivityType;
import com.langapp.domain.activity.dto.ActivityDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ActivityMapper {

    private final Map<ActivityType, SpecificActivityMapper<?>> activityMappers;

    public ActivityMapper(List<SpecificActivityMapper<?>> mapperList) {
        this.activityMappers = mapperList.stream()
                .collect(Collectors.toMap(
                        SpecificActivityMapper::getActivityType,
                        mapper -> mapper
                ));
    }

    public ActivityDto mapToActivityDto(final Activity activity) {
        SpecificActivityMapper<?> activityMapper = activityMappers.get(activity.getActivityType());

        if (activityMapper == null) {
            throw new IllegalStateException("No activityMapper found for type " + activity.getActivityType());
        }

        return activityMapper.mapToDto(activity);
    }

    public List<ActivityDto> mapToActivityDtoList(final List<Activity> activities) {
        return activities.stream()
                .map(this::mapToActivityDto)
                .toList();
    }
}
