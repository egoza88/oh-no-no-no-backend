package com.ohnonono.parking.controllers;

import com.ohnonono.parking.model.Note;
import com.ohnonono.parking.service.NoteService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/notes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class NotesRestController {

    @Autowired
    private NoteService noteService;

    @GetMapping(value = "/")
    @ApiOperation(value = "Get all notes", notes = "Retrieving the collection of user notes", response = Note[].class)
    public List<Note> getAllNotes() {
        return noteService.findAll();
    }

    @GetMapping(value = "/get/{id}")
    @ApiOperation(value = "Get note by id", notes = "Retrieving note by id", response = Note[].class)
    public Note getById(@PathVariable String id) {
        return noteService.findById(id);
    }

    @PostMapping("/save")
    @ApiOperation(value = "Create of update note", notes = "Create or update note", response = Note[].class)
    Note newNote(@RequestBody Note newNote) {
        return noteService.saveOrUpdateNote(newNote);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Delete note by id", notes = "Delete note by id", response = Note[].class)
    void deleteEmployee(@PathVariable String id) {
        noteService.deleteNoteById(id);
    }
}
