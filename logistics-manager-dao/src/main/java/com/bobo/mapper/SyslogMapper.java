package com.bobo.mapper;

import com.bobo.pojo.Syslog;
import com.bobo.pojo.SyslogExample;
import com.bobo.pojo.SyslogWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SyslogMapper {
    long countByExample(SyslogExample example);

    int deleteByExample(SyslogExample example);

    int deleteByPrimaryKey(Integer logid);

    int insert(SyslogWithBLOBs record);

    int insertSelective(SyslogWithBLOBs record);

    List<SyslogWithBLOBs> selectByExampleWithBLOBs(SyslogExample example);

    List<Syslog> selectByExample(SyslogExample example);

    SyslogWithBLOBs selectByPrimaryKey(Integer logid);

    int updateByExampleSelective(@Param("record") SyslogWithBLOBs record, @Param("example") SyslogExample example);

    int updateByExampleWithBLOBs(@Param("record") SyslogWithBLOBs record, @Param("example") SyslogExample example);

    int updateByExample(@Param("record") Syslog record, @Param("example") SyslogExample example);

    int updateByPrimaryKeySelective(SyslogWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(SyslogWithBLOBs record);

    int updateByPrimaryKey(Syslog record);
}