package com.lanou.upms.service.impl;

import com.lanou.upms.bean.LayUITableData;
import com.lanou.upms.bean.Role;
import com.lanou.upms.mapper.RoleMapper;
import com.lanou.upms.mapper.TestRoleMapper;
import com.lanou.upms.service.RoleService;
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
public class RoleServiceImpl implements RoleService {
    private List<Role> roleCache=null;

    @Autowired
    private RoleMapper roleMapper;

  /* @Override
    public List<Role> queryRole(Role condition) {
        RoleExample roleExample = new RoleExample();
        RoleExample.Criteria criteria = roleExample.createCriteria();
        if (condition != null){
            if (condition.getRoleId() != null){
                criteria.andRoleIdEqualTo(condition.getRoleId());
            }
            if (condition.getRoleName() != null){
                criteria.andRoleNameEqualTo(condition.getRoleName());
            }
        }
        return roleMapper.selectByExample(roleExample);
    }*/

    @Override
    public LayUITableData<Role> queryRoleForLayUI(Role condition, Integer pageSize, Integer currentPage) {

        if (roleCache == null) {
            roleCache = queryAll();
        }
        int startIdx = (currentPage - 1) * pageSize;
        int endIdx = currentPage * pageSize;
        if (endIdx > roleCache.size()) {
            endIdx = roleCache.size();
        }

        List<Role> currentPageData = roleCache.subList(startIdx, endIdx);

        LayUITableData<Role> retData = new LayUITableData();
        retData.setCode(0);
        retData.setCount((long) (roleCache.size()));
        retData.setMsg("查询成功");
        retData.setData(currentPageData);
        System.out.println();
        roleCache = null;
        return retData;
    }

   @Override
    public List<Role> queryAll() {

        InputStream is= null;
        try {
            is = Resources.getResourceAsStream("mybatis.xml");

        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory =  new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession =  sqlSessionFactory.openSession(true);
        TestRoleMapper testRoleMapper =  sqlSession.getMapper(TestRoleMapper.class);
        List<Role> role = testRoleMapper.queryAll();
        System.out.println(role);
        return role;
    }

    @Override
    public int update(String id) {
        InputStream is= null;
        try {
            is = Resources.getResourceAsStream("mybatis.xml");

        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession =  sqlSessionFactory.openSession(true);
        TestRoleMapper testRoleMapper =   sqlSession.getMapper(TestRoleMapper.class);
        return testRoleMapper.update(id);
    }



}

