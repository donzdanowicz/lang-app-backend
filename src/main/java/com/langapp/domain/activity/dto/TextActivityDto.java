package com.langapp.domain.activity.dto;

import com.langapp.domain.text.dto.TextDto;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TextActivityDto extends ActivityDto {
    private TextDto text;
}
