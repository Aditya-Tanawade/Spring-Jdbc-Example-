package com.Aditya.SpringJdbcExample.repository;

import com.Aditya.SpringJdbcExample.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    private JdbcTemplate jdbc;

    public void save(Student s ){
        String query="Insert into student (rollno,name,marks ) values (?,?,?)";
        int rows = jdbc.update(query,s.getRollNo(),s.getName(),s.getMarks());
        System.out.println(rows + "  Affected ");
    }

    public List<Student> findAll() {
        String sql="select * from student ";


         return jdbc.query(sql, ( rs,   rowNum) -> {
            Student s=new Student();
            s.setRollNo(rs.getInt("rollno"));
            s.SetName(rs.getString("name"));
            s.setMarks(rs.getInt("marks"));
            return s;
        });

//        List<Student>students=new ArrayList<>();
//        return students;
    }
}
