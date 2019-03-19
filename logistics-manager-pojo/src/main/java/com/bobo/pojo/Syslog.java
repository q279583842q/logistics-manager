package com.bobo.pojo;

import java.util.Date;

public class Syslog {
    private Integer logid;

    private Integer fkTypeid;

    private Integer fkUserid;

    private String procname;

    private String ip;

    private Date checkintime;

    private Integer isexception;

    public Integer getLogid() {
        return logid;
    }

    public void setLogid(Integer logid) {
        this.logid = logid;
    }

    public Integer getFkTypeid() {
        return fkTypeid;
    }

    public void setFkTypeid(Integer fkTypeid) {
        this.fkTypeid = fkTypeid;
    }

    public Integer getFkUserid() {
        return fkUserid;
    }

    public void setFkUserid(Integer fkUserid) {
        this.fkUserid = fkUserid;
    }

    public String getProcname() {
        return procname;
    }

    public void setProcname(String procname) {
        this.procname = procname == null ? null : procname.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Date getCheckintime() {
        return checkintime;
    }

    public void setCheckintime(Date checkintime) {
        this.checkintime = checkintime;
    }

    public Integer getIsexception() {
        return isexception;
    }

    public void setIsexception(Integer isexception) {
        this.isexception = isexception;
    }
}