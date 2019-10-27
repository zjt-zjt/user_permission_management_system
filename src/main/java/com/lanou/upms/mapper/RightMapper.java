package com.lanou.upms.mapper;

import com.lanou.upms.bean.Right;
import com.lanou.upms.bean.RightExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RightMapper {
    long countByExample(RightExample example);

    int deleteByExample(RightExample example);

    int deleteByPrimaryKey(Integer rightId);

    int insert(Right record);

    int insertSelective(Right record);

    List<Right> selectByExample(RightExample example);

    Right selectByPrimaryKey(Integer rightId);

    int updateByExampleSelective(@Param("record") Right record, @Param("example") RightExample example);

    int updateByExample(@Param("record") Right record, @Param("example") RightExample example);

    int updateByPrimaryKeySelective(Right record);

    int updateByPrimaryKey(Right record);
}