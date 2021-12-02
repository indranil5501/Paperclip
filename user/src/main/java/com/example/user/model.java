package com.example.user;

public class model {

    String shopname,ownname,shopadd,connum;

    public model() {

    }

    public model(String shopname, String ownname, String shopadd, String connum) {
        this.shopname = shopname;
        this.ownname = ownname;
        this.shopadd = shopadd;
        this.connum = connum;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public String getOwnname() {
        return ownname;
    }

    public void setOwnname(String ownname) {
        this.ownname = ownname;
    }

    public String getShopadd() {
        return shopadd;
    }

    public void setShopadd(String shopadd) {
        this.shopadd = shopadd;
    }

    public String getConnum() {
        return connum;
    }

    public void setConnum(String connum) {
        this.connum = connum;
    }
}
