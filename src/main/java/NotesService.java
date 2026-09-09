package com.example.studyroom;

import com.example.studyroom.Notes;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NotesService   {
    private com.example.studyroom.NotesRepository notesrepository;

    public NotesService(com.example.studyroom.NotesRepository notesrepository)   {
        this.notesrepository = notesrepository;
    }

    public Notes saveNotes(Notes notes)  {
        return notesrepository.save(notes);
    }

    public List<Notes> getAllNotes() {
        return notesrepository.findAll();
    }

    public Notes getNotesById(int id)  {
        return notesrepository.findById(id)
                .orElseThrow( () -> new NotesNotFoundException(id));
    }

    public Notes updatenotes(int id, Notes updatenotes)  {
        Notes existing = notesrepository.findById(id)
                .orElseThrow(() -> new NotesNotFoundException(id));

        existing.setTitle(updatenotes.getTitle());
        existing.setExamType(updatenotes.getExamType());

        return notesrepository.save(existing);
    }


        public void deletenotes(int id)     {
                notesrepository.deleteById(id);
        }

}




