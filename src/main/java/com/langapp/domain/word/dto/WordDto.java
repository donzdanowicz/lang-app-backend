package com.langapp.domain.word.dto;

import com.langapp.common.Level;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class WordDto {
    private UUID id;
    private String word;
    private String translation;
    private String imageUrl;
    private String audioUrl;
    private Level level;
    private UUID categoryId;
}
