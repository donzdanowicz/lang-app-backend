package com.langapp.domain.activity;

import com.langapp.domain.lesson.Lesson;
import com.langapp.domain.word.Word;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "ACTIVITIES")
public class Activity {

    @Id
    @GeneratedValue
    @Column(name = "ID", columnDefinition = "UUID")
    private UUID id;

    @Column(name = "ACTIVITY_TYPE")
    @Enumerated(EnumType.STRING)
    private ActivityType activityType;

    @Column(name = "ACTIVITY_ORDER")
    private int order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LESSON_ID")
    private Lesson lesson;

    @ManyToMany
    @JoinTable(
            name = "WORDS_IN_ACTIVITIES",
            joinColumns = @JoinColumn(name = "ACTIVITY_ID"),
            inverseJoinColumns = @JoinColumn(name = "WORD_ID")
    )
    private List<Word> words = new ArrayList<>();


    @OneToOne(mappedBy = "activity", cascade = CascadeType.ALL)
    private TextActivity textActivity;

    @OneToOne(mappedBy = "activity", cascade = CascadeType.ALL)
    private WordsActivity wordsActivity;

    @OneToOne(mappedBy = "activity", cascade = CascadeType.ALL)
    private QuizWordsActivity quizWordsActivity;

    @OneToOne(mappedBy = "activity", cascade = CascadeType.ALL)
    private QuizSentencesActivity quizSentencesActivity;

    @OneToOne(mappedBy = "activity", cascade = CascadeType.ALL)
    private ListeningActivity listeningActivity;

    @OneToOne(mappedBy = "activity", cascade = CascadeType.ALL)
    private MemoryActivity memoryActivity;

}
