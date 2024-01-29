package com.jux.notemanager.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "note")
public class Note {

    @Id
    @GeneratedValue
    protected long id;

    @Column(name = "title")
    protected String title;

    @Column(name = "content")
    protected String content;

    @Column(name = "author")
    protected String author;


    public Note() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
