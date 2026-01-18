package com.langapp.domain.sentence;

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
@Table(name = "SENTENCES")
public class Sentence {

    @Id
    @GeneratedValue
    @Column(name = "ID", columnDefinition = "UUID")
    private UUID id;

    @Column(name = "CONTENT")
    private String content;

    @Builder.Default
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "WORDS_IN_SENTENCES",
            joinColumns = @JoinColumn(name = "SENTENCE_ID"),
            inverseJoinColumns = @JoinColumn(name = "WORD_ID")
    )
    private List<Word> words = new ArrayList<>();
}
