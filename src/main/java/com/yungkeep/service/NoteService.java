package com.yungkeep.service;

import com.yungkeep.dto.NoteDto;
import com.yungkeep.exception.ResourceNotFoundException;
import com.yungkeep.model.Note;
import com.yungkeep.model.User;
import com.yungkeep.repository.NoteRepository;
import com.yungkeep.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private UserRepository userRepository;

    public NoteDto createNote(NoteDto noteDto, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Note note = new Note();
        note.setTitle(noteDto.getTitle());
        note.setContent(noteDto.getContent());
        note.setColor(noteDto.getColor());
        note.setTags(noteDto.getTags());
        note.setArchived(noteDto.isArchived());
        note.setDeleted(noteDto.isDeleted());
        note.setUser(user);

        note = noteRepository.save(note);

        return convertToDto(note);
    }

    public List<NoteDto> getAllUserNotes(Long userId) {
        return noteRepository.findByUserIdAndDeletedFalseOrderByUpdatedAtDesc(userId)
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public List<NoteDto> getArchivedNotes(Long userId) {
        return noteRepository.findByUserIdAndArchivedTrueAndDeletedFalseOrderByUpdatedAtDesc(userId)
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public List<NoteDto> getDeletedNotes(Long userId) {
        return noteRepository.findByUserIdAndDeletedTrueOrderByUpdatedAtDesc(userId)
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public List<NoteDto> getNotesByTag(Long userId, String tag) {
        return noteRepository.findByUserIdAndTagsContainingAndDeletedFalseOrderByUpdatedAtDesc(userId, tag)
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public NoteDto getNoteById(Long noteId, Long userId) {
        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note not found"));

        if (!note.getUser().getId().equals(userId)) {
            throw new ResourceNotFoundException("Note not found");
        }

        return convertToDto(note);
    }

    @Transactional
    public NoteDto updateNote(Long noteId, NoteDto noteDto, Long userId) {
        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note not found"));

        if (!note.getUser().getId().equals(userId)) {
            throw new ResourceNotFoundException("Note not found");
        }

        note.setTitle(noteDto.getTitle());
        note.setContent(noteDto.getContent());
        note.setColor(noteDto.getColor());
        note.setTags(noteDto.getTags());
        note.setArchived(noteDto.isArchived());
        note.setDeleted(noteDto.isDeleted());
        note.setUpdatedAt(LocalDateTime.now());

        note = noteRepository.save(note);

        return convertToDto(note);
    }

    @Transactional
    public void deleteNote(Long noteId, Long userId) {
        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note not found"));

        if (!note.getUser().getId().equals(userId)) {
            throw new ResourceNotFoundException("Note not found");
        }

        noteRepository.delete(note);
    }

    @Transactional
    public NoteDto archiveNote(Long noteId, Long userId) {
        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note not found"));

        if (!note.getUser().getId().equals(userId)) {
            throw new ResourceNotFoundException("Note not found");
        }

        note.setArchived(true);
        note.setUpdatedAt(LocalDateTime.now());
        note = noteRepository.save(note);
        return convertToDto(note);
    }

    @Transactional
    public NoteDto unarchiveNote(Long noteId, Long userId) {
        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note not found"));

        if (!note.getUser().getId().equals(userId)) {
            throw new ResourceNotFoundException("Note not found");
        }

        note.setArchived(false);
        note.setUpdatedAt(LocalDateTime.now());
        note = noteRepository.save(note);

        return convertToDto(note);
    }

    @Transactional
    public NoteDto moveToTrash(Long noteId, Long userId) {
        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note not found"));

        if (!note.getUser().getId().equals(userId)) {
            throw new ResourceNotFoundException("Note not found");
        }

        note.setDeleted(true);
        note.setUpdatedAt(LocalDateTime.now());
        note = noteRepository.save(note);

        return convertToDto(note);
    }

    @Transactional
    public NoteDto restoreFromTrash(Long noteId, Long userId) {
        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note not found"));

        if (!note.getUser().getId().equals(userId)) {
            throw new ResourceNotFoundException("Note not found");
        }

        note.setDeleted(false);
        note.setUpdatedAt(LocalDateTime.now());
        note = noteRepository.save(note);

        return convertToDto(note);
    }

    private NoteDto convertToDto(Note note) {
        NoteDto noteDto = new NoteDto();
        noteDto.setId(note.getId());
        noteDto.setTitle(note.getTitle());
        noteDto.setContent(note.getContent());
        noteDto.setColor(note.getColor());
        noteDto.setTags(note.getTags());
        noteDto.setCreatedAt(note.getCreatedAt());
        noteDto.setUpdatedAt(note.getUpdatedAt());
        noteDto.setArchived(note.isArchived());
        noteDto.setDeleted(note.isDeleted());
        return noteDto;
    }
}


