package com.example.demo.data;

import com.example.demo.models.Course;

import java.util.List;

public interface CourseDao {

    List<Course> getAll();

    List<Course> findUserCourses(String name);

}
