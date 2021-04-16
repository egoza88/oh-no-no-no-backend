package com.ohnonono.parking.service;

import com.ohnonono.parking.model.Note;

import java.util.List;

public interface NoteService {

    List<Note> findAll();

    Note findById(String id);

    Note saveOrUpdateNote(Note note);

    void deleteNoteById(String id);
}
