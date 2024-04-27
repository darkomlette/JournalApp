package com.example.journalapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "JOURNAL_TBL")
public class Journal implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String logTrail;

    public Journal(String logTrail) {
        this.logTrail = logTrail;
    }
}
