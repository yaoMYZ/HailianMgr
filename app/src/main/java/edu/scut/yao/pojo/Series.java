package edu.scut.yao.pojo;

import java.util.ArrayList;
import java.util.Date;

public class Series {
    private int id;
    private ArrayList<Procedure> procedure;
    private Date createTime;
    private Date updateTime;

    public Series(int id, ArrayList<Procedure> procedure, Date createTime, Date updateTime) {
        this.id = id;
        this.procedure = procedure;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Procedure> getProcedure() {
        return procedure;
    }

    public void setProcedure(ArrayList<Procedure> procedure) {
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
