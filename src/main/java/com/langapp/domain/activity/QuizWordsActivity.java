package com.langapp.domain.activity;

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
@Table(name = "QUIZ_WORDS_ACTIVITIES")
public class QuizWordsActivity {

    @Id
    @GeneratedValue
    @Column(name = "ID", columnDefinition = "UUID")
    private UUID id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACTIVITY_ID")
    private Activity activity;

    @Builder.Default
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "WORDS_IN_QUIZ_WORDS",
            joinColumns = @JoinColumn(name = "QUIZ_WORDS_ACTIVITY_ID"),
            inverseJoinColumns = @JoinColumn(name = "WORD_ID")
    )
    private List<Word> words = new ArrayList<>();

}
