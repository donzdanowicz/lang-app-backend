package com.langapp.mapper.activity;

import com.langapp.domain.activity.Activity;
import com.langapp.domain.activity.ActivityType;
import com.langapp.domain.activity.ReviewActivity;
import com.langapp.domain.activity.dto.ReviewActivityDto;
import com.langapp.mapper.WordMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ReviewActivityMapper implements SpecificActivityMapper<ReviewActivityDto> {

    private final WordMapper wordMapper;

    @Override
    public ActivityType getActivityType() {
        return ActivityType.REVIEW;
    }

    @Override
    public ReviewActivityDto mapToDto(Activity activity) {
        ReviewActivity reviewActivity = activity.getReviewActivity();

        return ReviewActivityDto.builder()
                .id(activity.getId())
                .activityType(ActivityType.REVIEW)
                .order(activity.getOrder())
                .words(wordMapper.mapToWordDtoList(reviewActivity.getWords()))
                .build();
    }
}
