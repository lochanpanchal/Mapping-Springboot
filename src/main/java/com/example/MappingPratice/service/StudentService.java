package com.example.MappingPratice.service;


import com.example.MappingPratice.model.Student;
import com.example.MappingPratice.repositroy.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    IStudentRepo iStudentRepo;

    public List<Student> Students() {
        return iStudentRepo.findAll();
    }

    public String createStudent(Student student) {
        iStudentRepo.save(student);
        return "Student is added to DB";
    }

    public String removeStudentById(Long id) {
        iStudentRepo.deleteById(id);
        return "Student removed by Id from DB";
    }

    public Student updateStudent(Student student, Long id) {
        Student existingStudent = iStudentRepo.findById(id).orElse(null);
        if(existingStudent != null){
            existingStudent.setAge(student.getAge());
            existingStudent.setBranch(student.getBranch());

            return iStudentRepo.save(existingStudent);
        }
        return null;
    }
}
