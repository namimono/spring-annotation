package com.namimono.dao;

import com.namimono.entities.Employee;
import com.namimono.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertUser(String name,String job){
        String sql="INSERT into employee(empName,job) VALUE(?,?)";
        jdbcTemplate.update(sql,name,job);

    }

    public List<Employee> getUser() {
        String sql="select * from employee";
        List<Employee> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Employee>(Employee.class));
        return list;
    }
}
