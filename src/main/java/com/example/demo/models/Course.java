package com.example.demo.models;


public class Course {
    private int courseId;
    private String name;
    private int mark;

    public Course() {
    }

    public Course(int courseId, String name, int mark ) {
        this.courseId = courseId;
        this.name = name;
        this.mark = mark;


    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getCourseId() {
        return courseId;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public int getMark() {
        return mark;
    }
}