package com.qf.mybatis.dao;

import com.qf.mybatis.pojo.User;

import java.util.List;

/*
 * zhaoyan 2020/10/20 15:01
 */
public interface UserDao {
    public User queryById(int id);
    public List<User> queryAll();
}
