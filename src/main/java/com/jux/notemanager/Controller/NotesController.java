package com.jux.notemanager.Controller;

import com.jux.notemanager.Model.Note;
import com.jux.notemanager.Service.NotesService;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController

public class NotesController {

    @Autowired
private NotesService notesService;


    @GetMapping("/note/{id}")
    public Optional<Note> getNote (@PathVariable("id") final Long id ) {
        return notesService.getNote(id);
    }


    @GetMapping("/notes")
    public Iterable<Note> getNotes(){
        return notesService.getNotes();
    }


    @PostMapping("/note")
    public Note createNote(@RequestBody Note note){
    return notesService.saveNote(note);
    }

//    @PutMapping("/note/{id}")
//    public Note updateNote(@PathVariable("id") final Long id, @RequestBody Note note){
//        Optional<Note> oldNote = notesService.getNote(id);
//                if (oldNote.isPresent()){
//                    Note newNote = oldNote.get();
//
//                    String title = note.getTitle();
//                    newNote.setTitle(title);
//
//                    String content = note.getContent();
//                    if (content != null)  newNote.setContent(content);
//
//                    String author = note.getContent();
//                    if (author != null)  newNote.setAuthor(author);
//
//                    return newNote;
//                }
//
//                else return null;

//    }
}
