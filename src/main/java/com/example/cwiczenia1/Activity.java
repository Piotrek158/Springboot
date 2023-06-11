package com.example.cwiczenia1;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@JsonSerialize
@Data
public class Activity {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("nazwa")
    private String name;

    @JsonProperty("priorytet")
    private Integer priority;

    public Activity(){

    }

    public Activity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}
