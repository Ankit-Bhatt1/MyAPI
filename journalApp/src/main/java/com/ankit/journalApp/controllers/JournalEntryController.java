package com.ankit.journalApp.controllers;

import com.ankit.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    private Map<Long , JournalEntry> journalEntries = new HashMap<>();

    @GetMapping
    public List<JournalEntry> getAll(){ //http://localhost:8080/journal
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myentry){ //http://localhost:8080/journal
        journalEntries.put(myentry.getId(),myentry);
        return true;
    }

    @GetMapping("id/{myid}")
    public JournalEntry getJournalEntryById(@PathVariable Long myid){
        return journalEntries.get(myid);
    }


    @DeleteMapping("id/{myid}")
    public JournalEntry deleteJournalEntryById(@PathVariable Long myid){
        return journalEntries.remove(myid);
    }

    @PutMapping("id/{id}")
    public JournalEntry updateJournalById(@PathVariable Long id,@RequestBody JournalEntry myentry){
        return journalEntries.put(id, myentry);
    }

}
