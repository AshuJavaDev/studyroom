package com.example.studyroom;

public class NotesNotFoundException  extends RuntimeException {
    public NotesNotFoundException(int id) {
        super("Note not found with id: " + id);
    }
}
