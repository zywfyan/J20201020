package com.qf.mybatis.dao;

import com.qf.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/*
 * zhaoyan 2020/10/20 14:43
 */
public class UserDAOTest {
    @Test
    public  void testQuery() {
        // 1. 读取mybatis-config配置文件
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2. 获取SqlSessionFactory
        // 工厂，生产一个SqlSession
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        // 3. 获取SqlSession
        // openSession参数: true: 自动提交事务; false: 手动提交事务
        // 使用无参方法的话，默认为true
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> users = mapper.queryAll();
        User user = mapper.queryById(2);
        User user1 = mapper.queryById(3);
        System.out.println("queryAll :" + users);
        System.out.println("2 :" + user);
        System.out.println("3 :" + user1);
    }
}
