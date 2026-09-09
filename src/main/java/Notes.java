package com.example.studyroom;

import jakarta.persistence.*;

@Entity
@Table(name = "notes")

public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String title;
    private String examType;

    public Notes() {
    }

    public Notes(String title, String examType) {
        this.title = title;
        this.examType = examType;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getExamType() {
        return examType;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setExamType(String examType) {
        this.examType = examType;
    }



}
