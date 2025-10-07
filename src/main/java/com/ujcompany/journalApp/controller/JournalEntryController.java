//package com.ujcompany.journalApp.controller;
//
//import com.ujcompany.journalApp.entity.JournalEntry;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.*;
//
//@RestController
//@RequestMapping("journal")
//public class JournalEntryController {
//
//    private Map<Long, JournalEntry> journalEntryMap = new HashMap<>();
//
//    @GetMapping
//    public List<JournalEntry> getJournalEntries() {
//        return new ArrayList<>(journalEntryMap.values());
//    }
//
//    @PostMapping
//    public boolean createEntry(@RequestBody JournalEntry myEntry){
//        journalEntryMap.put(myEntry.getId(), myEntry);
//        return true;
//    }
//
//    @GetMapping("id/{myId}")
//    public JournalEntry getJournalEntry(@PathVariable Long myId){
//        return journalEntryMap.get(myId);
//    }
//
//    @DeleteMapping("id/{myId}")
//    public JournalEntry deleteEntry(@PathVariable Long myId){
//        return journalEntryMap.remove(myId);
//    }
//
//    @PutMapping("id/{id}")
//    public JournalEntry updateEntry(@PathVariable long id, @RequestBody JournalEntry myEntry){
//        return journalEntryMap.put(id, myEntry);
//    }
//}
