package com.bobo.pojo;

public class Goods {
    private Integer goodsid;

    private String goodsname;

    private Integer amount;

    private Float weight;

    private Float volume;

    private Integer fkCarriersid;

    private Integer isdelete;

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname == null ? null : goodsname.trim();
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getVolume() {
        return volume;
    }

    public void setVolume(Float volume) {
        this.volume = volume;
    }

    public Integer getFkCarriersid() {
        return fkCarriersid;
    }

    public void setFkCarriersid(Integer fkCarriersid) {
        this.fkCarriersid = fkCarriersid;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }
}