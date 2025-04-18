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

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getColor() {
        return color;
    }

    public Set<String> getTags() {
        return tags;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public boolean isArchived() {
        return archived;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
