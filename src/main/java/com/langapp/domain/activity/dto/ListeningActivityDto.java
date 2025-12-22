package com.langapp.domain.activity.dto;

import com.langapp.domain.text.dto.TextDto;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ListeningActivityDto extends ActivityDto {
    private TextDto text;
    private String audioUrl; //TODO it is available in TextDto
}
