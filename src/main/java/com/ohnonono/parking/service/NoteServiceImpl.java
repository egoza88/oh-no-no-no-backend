package com.ohnonono.parking.service;

import com.ohnonono.parking.repository.NoteRepository;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.ohnonono.parking.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public List<Note> findAll() {
        return noteRepository.findAll();
    }

    @Override
    public Note findById(String id) {
        return noteRepository.findById(id).get();
    }

    @Override
    public Note saveOrUpdateNote(Note note) {
        if(note.getContent().startsWith("<p>[random]")) {
            updateNote(note);
        }
        return noteRepository.save(note);
    }

    @Override
    public void deleteNoteById(String id) {
        noteRepository.deleteById(id);
    }

    private void updateNote(Note note) {
        try{
            int num = Integer.parseInt(note.getContent()
                    .replace("<p>[random]", "")
                    .replace("</p>", "")
                    .trim());

            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("https://loripsum.net/api/"+num)
                    .get()
                    .build();

            Response response = client.newCall(request).execute();
            String responseBody = response.body().string();
            note.setContent(responseBody);
        }catch (NumberFormatException | IOException ignored) {
        }
    }
}
