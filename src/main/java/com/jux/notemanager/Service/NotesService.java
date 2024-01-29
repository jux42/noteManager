package com.jux.notemanager.Service;

import com.jux.notemanager.Model.Note;
import com.jux.notemanager.Repository.NotesRepository;
import lombok.Data;
import org.hibernate.annotations.processing.Find;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Optional;

@Data
@Service
public class NotesService {

    @Autowired
    private NotesRepository notesRepository;

    public Iterable<Note> getNotes(){
        return notesRepository.findAll();
    }

    public Optional<Note> getNote(final Long id){
        return notesRepository.findById(id);
    }


    public Note saveNote (Note note){
        return notesRepository.save(note);
    }

    public void deleteNote (Long id){

        notesRepository.deleteById(id);
    }
}
