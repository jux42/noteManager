package com.jux.notemanager.Controller;

import com.jux.notemanager.Model.Note;
import com.jux.notemanager.Service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.util.Optional;

@Controller

public class PageController {

    @Autowired
    NotesService notesService;

    @GetMapping("/index")
    public String index(Principal principal, Model model) {

        Iterable<Note> notes = notesService.getNotes();
        String text = "this is a test";
        model.addAttribute("text", text);
        model.addAttribute("notes", notes);


        return "index";
    }

    @GetMapping("page/form")
    public String noteForm(Model model) {
        System.out.println("first step");

        model.addAttribute("note", new Note());
        return "page";
    }

    @PostMapping("/page/form")
    public String noteSubmit(@ModelAttribute Note note, Model model) {

        String message = "OK !!!";
        notesService.saveNote(note);
        model.addAttribute("message", message);

        return "success";
    }

    @GetMapping("update/{id}")
    public String updateForm(@PathVariable("id") final Long id, Model model) {

        Optional<Note> note = notesService.getNote(id);
        if (note.isPresent()) {
            System.out.println(note);
            model.addAttribute("note", note.get());
            return "/updateform";
        } else return "index";
    }

    @PutMapping("/note/update/{id}")
    public String updateNote(@PathVariable("id") final Long id, Note note, Model model) {
        System.out.println(note.toString());
        Optional<Note> oldNote = notesService.getNote(id);
        if (oldNote.isPresent()) {
            Note newNote = oldNote.get();

            String title = note.getTitle();
            newNote.setTitle(title);

            String content = note.getContent();
            if (content != null) newNote.setContent(content);

            String author = note.getAuthor();
            if (author != null) newNote.setAuthor(author);

            notesService.saveNote(newNote);
            String message = "modification effectuée avec succès";
            model.addAttribute("message", message);
            return "success";
        } else return null;
    }

    @DeleteMapping("/note/delete/{id}")

    public String deleteUser(@PathVariable("id") Long id, Model model) {
        System.out.println("first step");
        notesService.deleteNote(id);
        String message = "suppression effectuée !";
        System.out.println("second step");

        model.addAttribute("message", message);
        System.out.println("third step");

        return "success";
    }
}