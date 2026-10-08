package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    // Since we don't have the database yet
    private Map<Long, JournalEntry> journalEntries = new HashMap<>();

    @GetMapping()
    public List<JournalEntry> getAll() {
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping()
    public String createEntry (@RequestBody JournalEntry requestData) {
        journalEntries.put(requestData.getId(), requestData);
        return "Entry created successfully!";
    }

    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable Long myId) {
        return journalEntries.get(myId);
    }

    @DeleteMapping("/id/{myId}")
    public JournalEntry deleteJournalEntryById (@PathVariable Long myId) {
        return journalEntries.remove(myId);
    }

    @PutMapping("id/{id}")
    public JournalEntry updateJournalEntryById(@PathVariable Long id, @RequestBody JournalEntry requestBody) {
        return journalEntries.put(id, requestBody);
    }

}
