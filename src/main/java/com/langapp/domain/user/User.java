package com.langapp.domain.user;

import com.langapp.common.Level;
import com.langapp.domain.achievement.Achievement;
import com.langapp.domain.revision.Revision;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "ID", columnDefinition = "UUID")
    private UUID id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "AGE")
    private int age;

    @Enumerated(EnumType.STRING)
    @Column(name = "CURRENT_LEVEL")
    private Level currentLevel;

    @Column(name = "USER_POINTS")
    private Long userPoints;

    @Column(name = "REGISTRATION_DATE")
    private LocalDate registrationDate;

    @Builder.Default
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Revision> revisions = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Achievement> achievements = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        registrationDate = LocalDate.now();
    }

}
