package com.example.subjectsApp;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@JsonSerialize
@Data
public class SubjcetEntry {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("ECTS")
    private Integer ects;

    @JsonProperty("room_no")
    private Integer room;

    @JsonProperty("exam")
    private Boolean exam;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoom() {
        return room;
    }

    public Boolean getExam() {
        return exam;
    }

}
