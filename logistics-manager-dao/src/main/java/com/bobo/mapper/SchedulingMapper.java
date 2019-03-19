package com.bobo.mapper;

import com.bobo.pojo.Scheduling;
import com.bobo.pojo.SchedulingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SchedulingMapper {
    long countByExample(SchedulingExample example);

    int deleteByExample(SchedulingExample example);

    int deleteByPrimaryKey(Integer schedulingid);

    int insert(Scheduling record);

    int insertSelective(Scheduling record);

    List<Scheduling> selectByExample(SchedulingExample example);

    Scheduling selectByPrimaryKey(Integer schedulingid);

    int updateByExampleSelective(@Param("record") Scheduling record, @Param("example") SchedulingExample example);

    int updateByExample(@Param("record") Scheduling record, @Param("example") SchedulingExample example);

    int updateByPrimaryKeySelective(Scheduling record);

    int updateByPrimaryKey(Scheduling record);
}