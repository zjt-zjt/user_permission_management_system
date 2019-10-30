package com.lanou.upms.service;

import com.lanou.upms.bean.Data;
import com.lanou.upms.bean.User;
import com.lanou.upms.bean.UserExample;
import com.lanou.upms.mapper.TestMapper;
import com.lanou.upms.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class UserListServiceImpl implements UserListService {
     private List<User>  UserCache =null ;
     @Autowired
     private UserMapper userMapper;


//    @Override
//    public List<User> queryusers(User user) {
//        UserExample userExample = new UserExample();
//        UserExample.Criteria criteria = userExample.createCriteria();
//        return userMapper.selectByExample(userExample);
//    }

    @Override
    public Data<User> queryUserList(User user, Integer pageSize, Integer currentPage) {
        if(UserCache == null) {
            UserCache = queryAll();
        }
        int startIdx = (currentPage - 1) * pageSize;
        int endIdx = currentPage * pageSize;

        if(endIdx > UserCache.size()) {
            endIdx = UserCache.size();
        }

        List<User> currentPageData = UserCache.subList(startIdx, endIdx);
        Data<User> retData = new Data();
        retData.setCode(0);
        retData.setCount((long)(UserCache.size()));
        retData.setMsg("");
        retData.setData(currentPageData);
        UserCache = null;
        return retData;

    }

    @Override
    public List<User> queryAll() {

        InputStream is= null;
        try {
            is = Resources.getResourceAsStream("mybatis_conf.xml");

        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession =  sqlSessionFactory.openSession(true);
        TestMapper testMapper =   sqlSession.getMapper(TestMapper.class);
        List<User> user = testMapper.queryAll();

        return user;
    }

    @Override
    public int update(String id) {
        InputStream is= null;
        try {
            is = Resources.getResourceAsStream("mybatis_conf.xml");

        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession =  sqlSessionFactory.openSession(true);
        TestMapper testMapper =   sqlSession.getMapper(TestMapper.class);

        return testMapper.update(id);
    }




}
