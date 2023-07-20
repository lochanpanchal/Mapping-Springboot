package com.example.MappingPratice.controller;

import com.example.MappingPratice.model.Address;
import com.example.MappingPratice.model.Student;
import com.example.MappingPratice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("Students")
    public List<Student> Students(){
        return studentService.Students();
    }
    @PostMapping("Student")
    public String createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }


    @PutMapping("updateStudent/{id}")
    private ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable Long id ){
        Student updatedStudent = studentService.updateStudent(student,id);
        if(updatedStudent != null){
            return ResponseEntity.ok(updatedStudent);
        }else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("removeStudent/{id}")
    public String removeStudentById(@PathVariable Long id){
        return studentService.removeStudentById(id);
    }

}
