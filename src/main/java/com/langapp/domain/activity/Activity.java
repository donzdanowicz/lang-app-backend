package com.langapp.domain.activity;

import com.langapp.domain.lesson.Lesson;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "ACTIVITIES")
public class Activity {

    @Id
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
