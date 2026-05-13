package com.example.studyroom;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.studyroom.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>      {

}