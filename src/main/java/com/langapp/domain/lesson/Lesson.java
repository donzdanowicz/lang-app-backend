package com.langapp.domain.lesson;

import com.langapp.common.Level;
import com.langapp.domain.text.Text;
import com.langapp.domain.word.Word;
import com.langapp.domain.activity.Activity;
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
@Table(name = "LESSONS")
public class Lesson {
    @Id
    @Column(name = "ID", columnDefinition = "UUID")
    private UUID id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "LEVEL")
    private Level level;

    @Builder.Default
    @ManyToMany
    @JoinTable(
            name = "WORDS_IN_LESSONS",
            joinColumns = @JoinColumn(name = "LESSON_ID"),
            inverseJoinColumns = @JoinColumn(name = "WORD_ID")
    )
    private List<Word> words = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "lesson", cascade =  CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Activity> activities = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "TEXT_ID")
    private Text text;
}
