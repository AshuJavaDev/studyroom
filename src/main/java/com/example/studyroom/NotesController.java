package com.example.studyroom;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotesController {

    private com.example.studyroom.NotesService notesservice;

    public NotesController(com.example.studyroom.NotesService notesservice) {
        this.notesservice = notesservice;
    }

    @PostMapping("/notes")
    public ResponseEntity<com.example.studyroom.Notes> saveNotes(@RequestBody com.example.studyroom.Notes notes)  {
        com.example.studyroom.Notes saved = notesservice.saveNotes(notes);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(saved);
    }

    @GetMapping("/notes")
    public List<com.example.studyroom.Notes> getAllNotes()  {
        return notesservice.getAllNotes();
    }

    @PutMapping("/notes/{id}")
    public com.example.studyroom.Notes updatenotes(@PathVariable int id, @RequestBody com.example.studyroom.Notes notes) {
        return notesservice.updatenotes(id, notes);
    }

    @DeleteMapping("/notes/{id}")
    public String deletenotes(@PathVariable int id)  {
        notesservice.deletenotes(id);
        return "Notes is deleted successfully";
    }


}
