package com.example.studyroom;

import com.example.studyroom.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
public class StudentController      {

    private StudentService studentservice;

    public StudentController(StudentService studentservice) {
        this.studentservice = studentservice;
    }

//    @PostMapping("/students")
//    public Student saveStudent(@RequestBody Student student)    {
//            return studentservice.saveStudent(student);
//    }

   @PostMapping("/students")
   public ResponseEntity<Student> saveStudent(@RequestBody Student student)     {
        Student saved = studentservice.saveStudent(student);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(saved);
   }

    @GetMapping("/students")
    public List<Student> getAllStudents()   {
        return studentservice.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable int id)    {
        return studentservice.getStudentById(id);
    }

    @PutMapping("/students/{id}")
    public Student updatestudent(@PathVariable int id, @RequestBody Student student)    {
        return studentservice.updatestudent(id, student);
    }

    @DeleteMapping("/students/{id}")
    public String deletestudent(@PathVariable int id)   {
        studentservice.deleteStudent(id);
        return "Student is deleted successfully";
    }
}