package com.example.studyroom;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface NotesRepository extends JpaRepository<com.example.studyroom.Notes, Integer> {
}
