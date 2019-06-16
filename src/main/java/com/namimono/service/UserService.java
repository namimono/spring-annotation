package com.namimono.service;

import com.namimono.dao.UserDao;
import com.namimono.entities.Employee;
import com.namimono.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
   UserDao userDao;
    @Transactional(isolation =Isolation.READ_UNCOMMITTED)
    public void insertUser(String name,String job) throws InterruptedException {
        System.out.println("insert..........");
        userDao.insertUser(name,job);
//        Thread.sleep(8000);
        int a=1/0;
    }
    @Transactional(isolation =Isolation.READ_UNCOMMITTED)
    public List<Employee> getUser() throws InterruptedException {
        System.out.println("get..........");
        List<Employee> list = userDao.getUser();
        return list;
    }
}
