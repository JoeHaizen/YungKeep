/*
package com.yungkeep.controller;

import com.yungkeep.dto.NoteDto;
import com.yungkeep.service.NoteService;
import com.yungkeep.service.UserDetailsImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping
    public ResponseEntity<List<NoteDto>> getAllNotes(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        List<NoteDto> notes = noteService.getAllUserNotes(userDetails.getId());
        return ResponseEntity.ok(notes);
    }

    @GetMapping("/archived")
    public ResponseEntity<List<NoteDto>> getArchivedNotes(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        List<NoteDto> notes = noteService.getArchivedNotes(userDetails.getId());
        return ResponseEntity.ok(notes);
    }

    @GetMapping("/deleted")
    public ResponseEntity<List<NoteDto>> getDeletedNotes(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        List<NoteDto> notes = noteService.getDeletedNotes(userDetails.getId());
        return ResponseEntity.ok(notes);
    }

    @GetMapping("/tag/{tag}")
    public ResponseEntity<List<NoteDto>> getNotesByTag(
            @PathVariable String tag,
            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        List<NoteDto> notes = noteService.getNotesByTag(userDetails.getId(), tag);
        return ResponseEntity.ok(notes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NoteDto> getNoteById(
            @PathVariable Long id,
            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        NoteDto note = noteService.getNoteById(id, userDetails.getId());
        return ResponseEntity.ok(note);
    }

    @PostMapping
    public ResponseEntity<NoteDto> createNote(
            @Valid @RequestBody NoteDto noteDto,
            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        NoteDto createdNote = noteService.createNote(noteDto, userDetails.getId());
        return new ResponseEntity<>(createdNote, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NoteDto> updateNote(
            @PathVariable Long id,
            @Valid @RequestBody NoteDto noteDto,
            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        NoteDto updatedNote = noteService.updateNote(id, noteDto, userDetails.getId());
        return ResponseEntity.ok(updatedNote);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(
            @PathVariable Long id,
            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        noteService.deleteNote(id, userDetails.getId());
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/archive")
    public ResponseEntity<NoteDto> archiveNote(
            @PathVariable Long id,
            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        NoteDto archivedNote = noteService.archiveNote(id, userDetails.getId());
        return ResponseEntity.ok(archivedNote);
    }

    @PutMapping("/{id}/unarchive")
    public ResponseEntity<NoteDto> unarchiveNote(
            @PathVariable Long id,
            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        NoteDto unarchivedNote = noteService.unarchiveNote(id, userDetails.getId());
        return ResponseEntity.ok(unarchivedNote);
    }

    @PutMapping("/{id}/trash")
    public ResponseEntity<NoteDto> moveToTrash(
            @PathVariable Long id,
            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        NoteDto trashedNote = noteService.moveToTrash(id, userDetails.getId());
        return ResponseEntity.ok(trashedNote);
    }

    @PutMapping("/{id}/restore")
    public ResponseEntity<NoteDto> restoreFromTrash(
            @PathVariable Long id,
            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        NoteDto restoredNote = noteService.restoreFromTrash(id, userDetails.getId());
        return ResponseEntity.ok(restoredNote);
    }
}
*/
