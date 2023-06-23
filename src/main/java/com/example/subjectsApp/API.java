package com.example.subjectsApp;

import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("API")
public class API {

    @Autowired
    private SubjectsDataBase subjetsDataBase;
    @GetMapping("test")
    public String test(){
        return "test";
    }

    @PostMapping(value="classes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void addEntry(@RequestBody SubjcetEntry entry){subjetsDataBase.addEntry(entry);
    }

    @GetMapping(value="classes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SubjcetEntry> getEnteries(@Nullable @RequestParam("room_no") Integer room_no, @Nullable @RequestParam("exam") Boolean exam){
        return subjetsDataBase.getAllEntries(room_no, exam);
    }

    @DeleteMapping(value = "classes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteEntries(){subjetsDataBase.deleteAll();}

    @GetMapping(value = "classes/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getEntryById(@PathVariable("id") Integer id){
        SubjcetEntry entry = subjetsDataBase.getEntryById(id);
        if(entry == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(entry);
    }

    @DeleteMapping(value = "classes/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteId(@PathVariable("id") Integer id){subjetsDataBase.deleteEntryById(id);}
}
