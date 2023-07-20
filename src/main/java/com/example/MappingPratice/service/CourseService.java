package com.example.MappingPratice.service;

import com.example.MappingPratice.model.Course;
import com.example.MappingPratice.model.Student;
import com.example.MappingPratice.repositroy.ICourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    ICourseRepo iCourseRepo;

    public List<Course> courses() {
        return iCourseRepo.findAll();
    }

    public String createCourse(Course course) {
        iCourseRepo.save(course);
        return "new courses is created in DB";
    }


    public String removeCourseById(Long id) {
        iCourseRepo.deleteById(id);
        return "Course By id is removed from DB";
    }

    public Course updateCourse(Long id, Course course) {
        Course existingCourse = iCourseRepo.findById(id).orElse(null);
        if(existingCourse != null){
            existingCourse.setTitle(course.getTitle());
            existingCourse.setDescription(course.getDescription());

            return iCourseRepo.save(existingCourse);
        }
        return null;
    }
}
