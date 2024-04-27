package com.example.journalapp.controller;

import com.example.journalapp.entity.Journal;
import com.example.journalapp.entity.User;
import com.example.journalapp.repository.JournalRepository;
import com.example.journalapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/journal")
public class JournalController {

    @Autowired
    JournalRepository journalRepository;

    @GetMapping("/getJournalRecords")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_MODERATOR') or hasAuthority('ROLE_USER')")
    public ResponseEntity<?> fetchUserDetails(Principal principal) {
        List<Journal> allJournalEntries = journalRepository.findAll();
        if(allJournalEntries!=null)
        {
            return ResponseEntity.ok(allJournalEntries);
        }
        return ResponseEntity.badRequest().body("No records found");

    }

}
