package com.yungkeep.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class NoteDto {
    private Long id;
    private String title;
    private String content;
    private String color;
    private Set<String> tags;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean archived;
    private boolean deleted;
}