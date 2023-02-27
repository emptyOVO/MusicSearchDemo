package com.example.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalTime;

/**
 * <p>
 * Searchs实体类
 * </p>
 *
 * @author feige
 * @since 2023-02-26
 */
@TableName("searches")
public class Searchs implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "sid", type = IdType.AUTO)
    private Integer sid;

    private String ssong;

    private String ssinger;

    private String salbum;

    private Time stime;


    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }
    public String getSsong() {
        return ssong;
    }

    public void setSsong(String ssong) {
        this.ssong = ssong;
    }
    public String getSsinger() {
        return ssinger;
    }

    public void setSsinger(String ssinger) {
        this.ssinger = ssinger;
    }
    public String getSalbum() {
        return salbum;
    }

    public void setSalbum(String salbum) {
        this.salbum = salbum;
    }
    public Time getStime() {
        return stime;
    }

    public void setStime(Time stime) {
        this.stime = stime;
    }

    @Override
    public String toString() {
        return "Searchs{" +
            "sid=" + sid +
            ", ssong=" + ssong +
            ", ssinger=" + ssinger +
            ", salbum=" + salbum +
            ", stime=" + stime +
        "}";
    }
}
