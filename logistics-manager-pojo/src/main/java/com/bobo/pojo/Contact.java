package com.bobo.pojo;

public class Contact {
    private Integer contactid;

    private Integer fkTruckid;

    private Integer fkDriverid;

    public Integer getContactid() {
        return contactid;
    }

    public void setContactid(Integer contactid) {
        this.contactid = contactid;
    }

    public Integer getFkTruckid() {
        return fkTruckid;
    }

    public void setFkTruckid(Integer fkTruckid) {
        this.fkTruckid = fkTruckid;
    }

    public Integer getFkDriverid() {
        return fkDriverid;
    }

    public void setFkDriverid(Integer fkDriverid) {
        this.fkDriverid = fkDriverid;
    }
}