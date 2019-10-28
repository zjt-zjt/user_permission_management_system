package com.lanou.upms.mapper;

import com.lanou.upms.bean.Purview;
import com.lanou.upms.bean.PurviewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface PurviewMapper {
    long countByExample(PurviewExample example);

    int deleteByExample(PurviewExample example);

    int deleteByPrimaryKey(Integer purviewId);

    int insert(Purview record);

    int insertSelective(Purview record);

    List<Purview> selectByExample(PurviewExample example);

    Purview selectByPrimaryKey(Integer purviewId);

    int updateByExampleSelective(@Param("record") Purview record, @Param("example") PurviewExample example);

    int updateByExample(@Param("record") Purview record, @Param("example") PurviewExample example);

    int updateByPrimaryKeySelective(Purview record);

    int updateByPrimaryKey(Purview record);
}