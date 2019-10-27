package com.lanou.upms.mapper;

import com.lanou.upms.bean.RoleRight;
import com.lanou.upms.bean.RoleRightExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleRightMapper {
    long countByExample(RoleRightExample example);

    int deleteByExample(RoleRightExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RoleRight record);

    int insertSelective(RoleRight record);

    List<RoleRight> selectByExample(RoleRightExample example);

    RoleRight selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RoleRight record, @Param("example") RoleRightExample example);

    int updateByExample(@Param("record") RoleRight record, @Param("example") RoleRightExample example);

    int updateByPrimaryKeySelective(RoleRight record);

    int updateByPrimaryKey(RoleRight record);
}