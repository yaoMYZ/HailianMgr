package edu.scut.yao.pojo;

import java.util.Date;

import edu.scut.yao.R;

public class Product {
    private int id;
    private String name;
    private String imagePath;
    private Date createTime;
    private Date updateTime;
    private float price;
    private String state;
    private Series series;
    private String description;

    public Product() {
    }

    public Product(int id, String name, String imagePath, Date createTime, Date updateTime, float price, String state, Series series, String description) {
        this.id = id;
        this.name = name;
        this.imagePath = imagePath;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.price = price;
        this.state = state;
        this.series = series;
        this.description = description;
    }

    public Product(String name, String imagePath, Date createTime, Date updateTime, float price, String state, Series series, String description) {
        this.name = name;
        this.imagePath = imagePath;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.price = price;
        this.state = state;
        this.series = series;
        this.description = description;
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

    public int getImage(){
        // 之后从写为根据imagePath查询到图片
        return R.drawable.knife;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
