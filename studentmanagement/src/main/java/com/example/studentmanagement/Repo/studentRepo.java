package com.example.studentmanagement.Repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.studentmanagement.models.Student;

@Repository
public class studentRepo {

    private JdbcTemplate jdbc;
    
    public JdbcTemplate getJdbc() {
        return jdbc;
    }
    
    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Student s) {
        String sql = "insert into student (rollno,name,mark) values (?,?,?)";
        int rows = jdbc.update(    sql,s.getRollNo(),s.getName(),s.getMark());
        System.out.println(rows + "affected");
    }

public List<Student> findAll() {
    String sql = "select * from student";

    RowMapper<Student> mapper = new RowMapper<Student>() {
        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student s = new Student();
            s.setRollNo(rs.getInt("rollno"));
            s.setName(rs.getString("name"));
            s.setMark(rs.getInt("mark"));
            return s;
        }
    };

    List<Student> students = jdbc.query(sql, mapper);
    return students;
}
}
