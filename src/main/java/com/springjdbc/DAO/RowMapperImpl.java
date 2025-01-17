package com.springjdbc.DAO;

import com.springjdbc.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperImpl implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
       Student student = new Student();
       student.setId(rs.getInt("id"));
       student.setName(rs.getString("name"));
       student.setCity(rs.getString("city"));
       return student;
    }
}
