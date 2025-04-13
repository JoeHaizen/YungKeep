package com.yungkeep.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "notes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    private String color;

    @ElementCollection
    @CollectionTable(name = "note_tags", joinColumns = @JoinColumn(name = "note_id"))
    @Column(name = "tag")
    private Set<String> tags = new HashSet<>();

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private boolean archived;

    private boolean deleted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
