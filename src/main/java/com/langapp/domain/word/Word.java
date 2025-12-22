package com.langapp.domain.word;

import com.langapp.common.Level;
import com.langapp.domain.activity.Activity;
import com.langapp.domain.category.Category;
import com.langapp.domain.lesson.Lesson;
import com.langapp.domain.revision.Revision;
import com.langapp.domain.sentence.Sentence;
import com.langapp.domain.text.Text;
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
@Table(name = "WORDS")
public class Word {
    @Id
    @Column(name = "ID", columnDefinition = "UUID")
    private UUID id;

    @Column(name = "WORD")
    private String word;

    @Column(name = "TRANSLATION")
    private String translation;

    @Column(name = "IMAGE_URL")
    private String imageUrl;

    @Column(name = "AUDIO_URL")
    private String audioUrl;

    @Enumerated(EnumType.STRING)
    @Column(name = "LEVEL")
    private Level level;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    @Builder.Default
    @ManyToMany(mappedBy = "words", fetch = FetchType.LAZY)
    private List<Sentence> sentences = new ArrayList<>();

    @Builder.Default
    @ManyToMany(mappedBy = "words", fetch = FetchType.LAZY)
    private List<Lesson> lessons = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "word", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Revision> revisions = new ArrayList<>();

    @Builder.Default
    @ManyToMany(mappedBy = "words")
    private List<Text> texts =  new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "EXERCISE_ID")
    private Activity activity;
}
