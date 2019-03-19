package com.bobo.mapper;

import com.bobo.pojo.Truckteam;
import com.bobo.pojo.TruckteamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TruckteamMapper {
    long countByExample(TruckteamExample example);

    int deleteByExample(TruckteamExample example);

    int deleteByPrimaryKey(Integer teamid);

    int insert(Truckteam record);

    int insertSelective(Truckteam record);

    List<Truckteam> selectByExample(TruckteamExample example);

    Truckteam selectByPrimaryKey(Integer teamid);

    int updateByExampleSelective(@Param("record") Truckteam record, @Param("example") TruckteamExample example);

    int updateByExample(@Param("record") Truckteam record, @Param("example") TruckteamExample example);

    int updateByPrimaryKeySelective(Truckteam record);

    int updateByPrimaryKey(Truckteam record);
}