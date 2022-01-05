package com.example.demo.data;


import com.example.demo.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

@Repository
@Profile("database")
public class CourseDatabaseDao implements CourseDao {
    private  DataSource ds;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CourseDatabaseDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Course> getAll() {
        final String sql = "SELECT * FROM course;";
        return jdbcTemplate.query(sql, new CourseDatabaseDao.CourseMapper());
    }

    @Override
    public  List<Course> findUserCourses(String name) {

        final String sql = "select  C.courseId, C.courseName from course c inner join student_course sc on c.courseId = sc.courseId where sc.userName=?;";
        return jdbcTemplate.query(sql, new CourseDatabaseDao.CourseMapper(),name);
    }



    private static final class CourseMapper implements RowMapper<Course> {

        @Override
        public Course mapRow(ResultSet rs, int index) throws SQLException {
            Course course = new Course();
            course.setCourseId(rs.getInt("courseId"));
            course.setName(rs.getString("courseName"));
            // course.setMark(rs.getInt("Mark"));
            return course;
        }
    }



}
