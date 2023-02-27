package com.example.sys.controller;

import com.example.common.vo.Result;
import com.example.sys.entity.User;
import com.example.sys.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  User前端控制器
 * </p>
 *
 * @author feige
 * @since 2023-02-26
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/all")
    public Result<List<User>> getAllUser() {
        List<User> list = userService.list();
        return Result.success(list,"查询成功");
    }

    @PostMapping("/login")
    public Result<Map<String,Object>> login(@RequestBody User user){
        Map<String, Object> data = userService.login(user);
        if(data!=null){
            return Result.success(data);
        }else return Result.fail(400,"用户名或密码错误");
    }

    @PostMapping("/adduser")
    public Result<?> addUser(@RequestBody User user,String uuid){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);
        Map<String, Object> data = new HashMap<>();
        data.put("newUser:",user);
        return Result.success(data,"新增用户成功");
    }

}
