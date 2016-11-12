package com.xueyou.ssm.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wuxueyou on 16/10/31.
 */
public class User2 {
    private String id;
    private String loginId;
    private String password;
    private String name;
    private String sex;
    private Date createTime;
    private Date birthday;
    private String status;
    private String dutyid;
    private String phone;
    private String email;
    private String photo;
    private Duty duty;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
//        if (sex == null || sex.equals("")) {
//            return "";
//        }
//        if (sex.equals("1")) {
//            return "男";
//        } else {
//            return "女";
//        }
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        try {
            this.createTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(createTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        try {
            this.birthday = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getStatus() {
        return status;
        /*if (status == null || status.equals("")) {
            return "";
        }
        if (status.equals("1")) {
            return "启用";
        } else {
            return "禁用";
        }*/
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDutyid() {
        return dutyid;
    }

    public void setDutyid(String dutyid) {
        this.dutyid = dutyid;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Duty getDuty() {
        return duty;
    }

    public void setDuty(Duty duty) {
        this.duty = duty;
    }

    @Override
    public String toString() {
        return "User2{" +
                "id='" + id + '\'' +
                ", loginId='" + loginId + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", createTime=" + createTime +
                ", birthday=" + birthday +
                ", status='" + status + '\'' +
                ", dutyid='" + dutyid + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", photo='" + photo + '\'' +
                ", duty=" + duty +
                '}';
    }
}
