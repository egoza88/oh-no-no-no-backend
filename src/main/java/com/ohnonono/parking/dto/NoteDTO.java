package com.ohnonono.parking.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoteDTO {

    private String id;
    private long timestamp;
    private String header;
    private String content;

    public NoteDTO() {
    }

    public NoteDTO(String id, long timestamp, String header, String content) {
        this.id = id;
        this.timestamp = timestamp;
        this.header = header;
        this.content = content;
    }
}
