package com.example.yangjiyeon.myapplication;

public class Item {
    String addr1;
    String addr2;
    String mapx;
    String mapy;
    String tel;
    String title;

    public String getaddr1() {
        return addr1;
    }

    public void setaddr1(String userID) {
        this.addr1 = addr1;
    }

    public String getaddr2() {
        return addr2;
    }

    public void setaddr2(String userPassword) {
        this.addr2 = addr2;
    }

    public String getmapx() {
        return mapx;
    }

    public void setmapx(String userAge) {
        this.mapx = mapx;
    }

    public String getmapy() {
        return mapy;
    }

    public void setmapy(String userName) {
        this.mapy = mapy;
    }

    public String gettel() {
        return tel;
    }

    public void settel(String userName) {
        this.tel = tel;
    }

    public String gettitle() {
        return title;
    }

    public void settitle(String userName) {
        this.title = title;
    }

    public Item(String addr1, String addr2, String mapx, String mapy, String tel, String title) {
        this.addr1 = addr1;
        this.addr2 = addr2;
        this.mapx = mapx;
        this.mapy = mapy;
        this.tel = tel;
        this.title = title;
    }
}