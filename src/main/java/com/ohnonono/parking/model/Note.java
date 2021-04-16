package com.ohnonono.parking.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

@Getter
@Setter
@Document(collection = "notes")
public class Note {

    @Id
    @NonNull()
    private String id;
    private long timestamp;
    private String header;
    private String content;

    public Note() {
    }

    public Note(long timestamp, String header, String content) {
        this.timestamp = timestamp;
        this.header = header;
        this.content = content;
    }

    public Note(@NonNull String id, long timestamp, String header, String content) {
        this.id = id;
        this.timestamp = timestamp;
        this.header = header;
        this.content = content;
    }
}
