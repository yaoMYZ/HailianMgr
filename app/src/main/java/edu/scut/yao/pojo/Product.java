package edu.scut.yao.pojo;

import java.util.Date;

public class Product {
    private int id;
    private String name;
    private String imagePath;
    private Date createTime;
    private Date updateTime;
    private float price;
    private String state;
    private Series series;

    public Product(int id, String name, String imagePath, Date createTime, Date updateTime, float price, String state, Series series) {
        this.id = id;
        this.name = name;
        this.imagePath = imagePath;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.price = price;
        this.state = state;
        this.series = series;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }
}
