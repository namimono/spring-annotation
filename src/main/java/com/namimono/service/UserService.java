package com.namimono.service;

import com.namimono.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
   UserDao userDao;
    @Transactional
    public void insertUser(String name,String job){
        System.out.println("insert..........");
        userDao.insertUser(name,job);
        int a=1/0;
    }
}
