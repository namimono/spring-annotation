package com.namimono.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertUser(String name,String job){
        String sql="INSERT into employee(empName,job) VALUE(?,?)";
        jdbcTemplate.update(sql,name,job);

    }
}
