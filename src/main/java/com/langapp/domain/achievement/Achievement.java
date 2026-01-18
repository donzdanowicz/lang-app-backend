package com.langapp.domain.achievement;

import com.langapp.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "ACHIEVEMENTS")
public class Achievement {
    @Id
    @Column(name = "ID", columnDefinition = "UUID")
    private UUID id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "IMAGE_URL")
    private String imageUrl;

    @Column(name = "UNLOCKED_AT")
    private LocalDateTime unlockedAt;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
}
