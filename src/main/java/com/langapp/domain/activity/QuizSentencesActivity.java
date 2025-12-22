package com.langapp.domain.activity;

import com.langapp.domain.sentence.Sentence;
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
@Table(name = "QUIZ_SENTENCES_ACTIVITIES")
public class QuizSentencesActivity {

    @Id
    @Column(name = "ID", columnDefinition = "UUID")
    private UUID id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACTIVITY_ID")
    private Activity activity;

    @Builder.Default
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "SENTENCES_IN_QUIZ_SENTENCES",
            joinColumns = @JoinColumn(name = "QUIZ_SENTENCES_ACTIVITY_ID"),
            inverseJoinColumns = @JoinColumn(name = "SENTENCE_ID")
    )
    private List<Sentence> sentences = new ArrayList<>();

}
