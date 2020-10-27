package edu.scut.yao.pojo;

public class User {
    private int id;
    private String phone;
    private String password;
    private String name;
    private int sex;
    private int position;

    public User() {
    }

    public User(int id, String phone, String password, String name, int sex, int position) {
        this.id = id;
        this.phone = phone;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
