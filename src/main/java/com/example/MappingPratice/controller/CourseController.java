package com.example.MappingPratice.controller;


import com.example.MappingPratice.model.Course;
import com.example.MappingPratice.model.Student;
import com.example.MappingPratice.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    CourseService courseService;


    @GetMapping("Courses")
    public List<Course> courses(){
        return courseService.courses();
    }
    @PostMapping("Course")
    public String createCourse(@RequestBody Course course){
        return courseService.createCourse(course);
    }

//    @GetMapping("Courses")
//    @PostMapping("Course")
//    @PutMapping("updateCourse/{CourseId}")
//    @DeleteMapping("removeCourse/{CourseId}")
    @PutMapping("updateCourse/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course course){
        Course updatedCourse = courseService.updateCourse(id,course);
        if(updatedCourse != null){
            return ResponseEntity.ok(course);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("removeCourse/{id}")
    public String removeCourseById(@PathVariable Long id){
        return  courseService.removeCourseById(id);
    }
}
