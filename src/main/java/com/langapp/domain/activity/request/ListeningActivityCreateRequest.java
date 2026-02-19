package com.langapp.domain.activity.request;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ListeningActivityCreateRequest {
    private UUID lessonId;
    private int order;
    private UUID textId;
}
