/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author tungn
 */
public class Students {
    private String code;
    private String name;
    private Date date;
    private String gender;
    private String sub;

    public Students() {
    }

    public Students(String code, String name, Date date, String gender, String sub) {
        this.code = code;
        this.name = name;
        this.date = date;
        this.gender = gender;
        this.sub = sub;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    @Override
    public String toString() {
        return "Students{" + "code=" + code + ", name=" + name + ", date=" + date + ", gender=" + gender + ", sub=" + sub + '}';
    }
    
    
}
