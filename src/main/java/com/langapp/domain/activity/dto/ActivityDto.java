package com.langapp.domain.activity.dto;

import com.langapp.domain.activity.ActivityType;
import lombok.*;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public abstract class ActivityDto {
    private UUID id;
    private ActivityType activityType;
    private int order;
}
