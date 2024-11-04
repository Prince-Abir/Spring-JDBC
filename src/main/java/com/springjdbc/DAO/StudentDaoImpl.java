package com.springjdbc.DAO;

import com.springjdbc.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    JdbcTemplate jdbcTemplate;
    @Override
    public int insert(Student student) {

        String query = "insert into student(id,name,city) values(?,?,?)";
        int result = this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
        return result;
    }

    @Override
    public int update(Student student) {
        String query = "UPDATE student set name=?, city=? where id=?";
        int result = this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
        return result;
    }

    @Override
    public int delete(int id) {
        String query = "DELETE from student where id=?";
        int result = this.jdbcTemplate.update(query,id);
        return result;
    }

    @Override
    public Student getStudent(int id) {
        String query = "SELECT * FROM student where id=?";
        RowMapperImpl rowMapper = new RowMapperImpl();
        Student student = this.jdbcTemplate.queryForObject(query,rowMapper,id);
        return student;
    }

    @Override
    public List<Student> getStudents() {
        String query = "SELECT * FROM student";
        RowMapperImpl rowMapper = new RowMapperImpl();
        List<Student> students = this.jdbcTemplate.query(query,rowMapper);
        return students;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
