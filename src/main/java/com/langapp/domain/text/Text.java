package com.langapp.domain.text;

import com.langapp.domain.lesson.Lesson;
import com.langapp.domain.word.Word;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "TEXTS")
public class Text {

    @Id
    @Column(name = "ID", columnDefinition = "UUID")
    private UUID id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "CONTENT", columnDefinition = "TEXT")
    private String content;

    @Column(name = "AUDIO_URL")
    private String audioUrl;

    @OneToOne(mappedBy = "text")
    private Lesson lesson;

    @Builder.Default
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "WORDS_IN_TEXTS",
            joinColumns = @JoinColumn(name = "TEXT_ID"),
            inverseJoinColumns = @JoinColumn(name = "WORD_ID")
    )
    private List<Word> words = new ArrayList<>();
}
