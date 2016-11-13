package com.xueyou.ssm.model;

import java.sql.Timestamp;

/**
 * Created by wuxueyou on 2016/11/12.
 */
public class Duty {
    private String id;
    private String dutyname;
    private String memo;
    private String depid;
    private String ordernumber;

    public Duty(String id, String dutyname, String memo, String depid, String ordernumber) {
        this.id = id;
        this.dutyname = dutyname;
        this.memo = memo;
        this.depid = depid;
        this.ordernumber = ordernumber;
    }

    public Duty(String id, String loginId, String password, String name, String sex, Timestamp createTime, Timestamp birthday, String status, String dutyid, String phone, String email, String photo, String did, String dutyname, String memo, String depid, String ordernumber) {
        this.id = did;
        this.dutyname = dutyname;
        this.memo = memo;
        this.depid = depid;
        this.ordernumber = ordernumber;
//        this.duty = new Duty(did, dutyname, memo, depid, ordernumber);
    }
    @Override
    public String toString() {
        return "Duty{" +
                "id='" + id + '\'' +
                ", dutyname='" + dutyname + '\'' +
                ", memo='" + memo + '\'' +
                ", depid='" + depid + '\'' +
                ", ordernumber='" + ordernumber + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDutyname() {
        return dutyname;
    }

    public void setDutyname(String dutyname) {
        this.dutyname = dutyname;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getDepid() {
        return depid;
    }

    public void setDepid(String depid) {
        this.depid = depid;
    }

    public String getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(String ordernumber) {
        this.ordernumber = ordernumber;
    }
}
