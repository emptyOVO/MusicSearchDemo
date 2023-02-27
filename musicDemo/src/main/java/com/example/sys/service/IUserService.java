package com.example.sys.service;

import com.example.sys.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  User服务类
 * </p>
 *
 * @author feige
 * @since 2023-02-26
 */
public interface IUserService extends IService<User> {
    Map<String, Object> login(User user);
}
