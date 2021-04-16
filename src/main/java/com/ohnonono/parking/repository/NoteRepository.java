package com.ohnonono.parking.repository;

import com.ohnonono.parking.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NoteRepository extends MongoRepository<Note, String> {
}
