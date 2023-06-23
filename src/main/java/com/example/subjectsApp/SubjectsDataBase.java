package com.example.subjectsApp;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("singleton")
public class SubjectsDataBase {

    private List<SubjcetEntry> subjectsEntryList = new ArrayList<>();
    private int entryIndex = 1;

    public void addEntry(SubjcetEntry entry) {
        entry.setId(entryIndex);
        subjectsEntryList.add(entry);
        entryIndex = entryIndex+1;
    }


    public List<SubjcetEntry> getAllEntries(Integer room_no, Boolean exam) {
        if (room_no == null && exam == null) {
            return new ArrayList<>(subjectsEntryList);
        } else {

            List<SubjcetEntry> filteredEntries = new ArrayList<>();

            for (SubjcetEntry entry : subjectsEntryList) {
                if ((room_no == null || entry.getRoom().equals(room_no))
                        && (exam == null || entry.getExam().equals(exam))) {
                    filteredEntries.add(entry);
                }
            }

            return filteredEntries;
        }
    }

    public void deleteAll() {
        subjectsEntryList.clear();
    }

    public SubjcetEntry getEntryById(Integer id) {
        for(SubjcetEntry entry : subjectsEntryList){
            if(entry.getId().equals(id)){
                return entry;
            }
        }
        return null;
    }

    public void deleteEntryById(Integer id){
        subjectsEntryList.removeIf(entry -> entry.getId().equals(id));
    }
}
