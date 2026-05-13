package com.example.studyroom;

import com.example.studyroom.Student;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService     {
    private StudentRepository studentrepository;

    public StudentService(StudentRepository studentrepository)  {
            this.studentrepository = studentrepository;
    }

            public Student saveStudent(Student student) {
                return studentrepository.save(student);
        }

        public List<Student> getAllStudents()   {
            return studentrepository.findAll();
    }

    public Student getStudentById(int id)   {
            return studentrepository.findById(id)
                                .orElseThrow( () -> new StudentNotFoundException(id));
    }

    public Student updatestudent(int id, Student updatestudent) {
        Student existing = studentrepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));

        existing.setName(updatestudent.getName());
        existing.setSubject(updatestudent.getSubject());

        return studentrepository.save(existing);
    }

            public void deleteStudent(int id)   {
                studentrepository.deleteById(id);
        }
    }
}