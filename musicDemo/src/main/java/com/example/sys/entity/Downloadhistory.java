package com.example.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalTime;

/**
 * <p>
 * DownloadHistory实体类
 * </p>
 *
 * @author feige
 * @since 2023-02-26
 */

public class Downloadhistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "dlhid", type = IdType.AUTO)
    private Integer dlhid;

    private String dlhsong;

    private String dlhsinger;

    private String album;

    private Time dlhtime;

    public Integer getDlhid() {
        return dlhid;
    }

    public void setDlhid(Integer dlhid) {
        this.dlhid = dlhid;
    }
    public String getDlhsong() {
        return dlhsong;
    }

    public void setDlhsong(String dlhsong) {
        this.dlhsong = dlhsong;
    }
    public String getDlhsinger() {
        return dlhsinger;
    }

    public void setDlhsinger(String dlhsinger) {
        this.dlhsinger = dlhsinger;
    }
    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }
    public Time getDlhtime() {
        return dlhtime;
    }

    public void setDlhtime(Time dlhtime) {
        this.dlhtime = dlhtime;
    }

    @Override
    public String toString() {
        return "Downloadhistory{" +
            "dlhid=" + dlhid +
            ", dlhsong=" + dlhsong +
            ", dlhsinger=" + dlhsinger +
            ", album=" + album +
            ", dlhtime=" + dlhtime +
        "}";
    }
}
