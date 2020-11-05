package edu.scut.yao.pojo;

import java.io.Serializable;
import java.util.Date;

public class Procedure implements Serializable {
    private int id;
    private String procedure;
    private Date createTime;
    private Date updateTime;

    public Procedure(int id, String procedure, Date createTime, Date updateTime) {
        this.id = id;
        this.procedure = procedure;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Procedure() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
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
}
