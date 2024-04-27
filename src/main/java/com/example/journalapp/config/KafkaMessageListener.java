package com.example.journalapp.config;

import com.example.journalapp.entity.Journal;
import com.example.journalapp.repository.JournalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener {

    @Autowired
    JournalRepository journalRepository;

    Logger log = LoggerFactory.getLogger(KafkaMessageListener.class);

    @KafkaListener(topics = "user_data_logs", groupId = "myGroup")
    public void consumeEvents(String data) {
        Journal journal = new Journal(data);
        journalRepository.save(journal);
        log.info("Consumer consumed the events {} -->", data);
    }

}
