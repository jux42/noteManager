package com.jux.notemanager.Repository;


import com.jux.notemanager.Model.Note;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface NotesRepository extends CrudRepository<Note, Long> {

}
