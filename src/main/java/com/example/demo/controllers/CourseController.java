package com.example.demo.controllers;

import com.example.demo.data.CourseDatabaseDao;
import com.example.demo.models.Course;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {


    //private final ToDoDao dao;
    private final CourseDatabaseDao dao;

    public CourseController(CourseDatabaseDao dao) {
        this.dao = dao;
    }

    @GetMapping
    public List<Course> all(){
        return dao.getAll();
    }



    @GetMapping("/{userName}")
    public ResponseEntity<List<Course>> findCourseById(@PathVariable String userName) {
        List<Course> result = dao.findUserCourses(userName);
        if (result == null) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(result);
    }






}
