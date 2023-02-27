package com.example.musicdemo.MyTests;

import com.example.sys.entity.User;
import com.example.sys.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class MusicDemoApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> user=userMapper.selectList(null);
        user.forEach(System.out::println);
    }

}
