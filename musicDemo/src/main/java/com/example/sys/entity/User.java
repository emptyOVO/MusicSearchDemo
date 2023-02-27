package com.example.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * <p>
 * User实体类
 * </p>
 *
 * @author feige
 * @since 2023-02-26
 */
@TableName("user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;

    private String password;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String pwd) {
        this.password = pwd;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
            "username=" + username +
            ", pwd=" + password +
            ", id=" + id +
        "}";
    }
}
