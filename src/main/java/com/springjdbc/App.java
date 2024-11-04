package com.springjdbc;


import com.springjdbc.DAO.StudentDao;
import com.springjdbc.DAO.StudentDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.codec.StringDecoder;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");


        StudentDaoImpl studentDao = context.getBean("studentDaoImpl", StudentDaoImpl.class);

//        Student student = new Student();
//        student.setId(5);
//        student.setName("Ridoy");
//        student.setCity("Dhaka");
//
//        int result = studentDao.insert(student);
//        System.out.println("Inserted: "+ result);

//        Student student = new Student(2,"Hasan","CTG");
//        int result = studentDao.update(student);
//        System.out.println("Updated : " + result);
//
//        int result = studentDao.delete(5);
//        System.out.println("Deleted successfully: "+result);

//        Student student = studentDao.getStudent(3);
//        System.out.println(student.getId());
//        System.out.println(student.getName());
//        System.out.println(student.getCity());

        List<Student> studentList = studentDao.getStudents();

        for(Student s:studentList){
            System.out.println(s);
        }



    }
}
