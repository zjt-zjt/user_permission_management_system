package com.lanou.upms.mapper;

import com.lanou.upms.bean.RolePurview;
import com.lanou.upms.bean.RolePurviewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolePurviewMapper {
    long countByExample(RolePurviewExample example);

    int deleteByExample(RolePurviewExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RolePurview record);

    int insertSelective(RolePurview record);

    List<RolePurview> selectByExample(RolePurviewExample example);

    RolePurview selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RolePurview record, @Param("example") RolePurviewExample example);

    int updateByExample(@Param("record") RolePurview record, @Param("example") RolePurviewExample example);

    int updateByPrimaryKeySelective(RolePurview record);

    int updateByPrimaryKey(RolePurview record);
}