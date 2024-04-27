package com.example.journalapp.repository;

import com.example.journalapp.entity.Journal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JournalRepository extends JpaRepository<Journal,Integer> {

    Optional<List<Journal>> findAllByIdIsNotNull();
}
