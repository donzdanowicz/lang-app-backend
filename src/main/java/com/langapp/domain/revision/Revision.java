package com.langapp.domain.revision;

import com.langapp.domain.user.User;
import com.langapp.domain.word.Word;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "REVISIONS")
public class Revision {

    @Id
    @GeneratedValue
    @Column(name = "ID", columnDefinition = "UUID")
    private UUID id;

    @Column(name = "CORRECT_COUNT")
    private int correctCount;

    @Column(name = "INCORRECT_COUNT")
    private int incorrectCount;

    @Column(name = "CREATED")
    private LocalDateTime created;

    @Column(name = "LAST_REVIEWED")
    private LocalDateTime lastReviewed;

    @Column(name = "NEXT_REVIEW")
    private LocalDateTime nextReview;

    @ManyToOne
    @JoinColumn(name = "WORD_ID")
    private Word word;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @PrePersist
    public void prePersist() {
        created = LocalDateTime.now();
    }

    public void updateAfterReview(boolean correct) {
        if (correct) {
            correctCount++;
        } else {
            incorrectCount++;
        }
        lastReviewed = LocalDateTime.now();
        int intervalDays = Math.max(1, correctCount * 2);
        nextReview = lastReviewed.plusDays(intervalDays);
    }
}
