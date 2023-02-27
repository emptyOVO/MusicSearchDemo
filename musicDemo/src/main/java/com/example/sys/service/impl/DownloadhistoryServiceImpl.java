package com.example.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.sys.entity.Downloadhistory;
import com.example.sys.mapper.DownloadhistoryMapper;
import com.example.sys.service.IDownloadhistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  Downloadhistory服务实现类
 * </p>
 *
 * @author feige
 * @since 2023-02-26
 */

@Service
public class DownloadhistoryServiceImpl extends ServiceImpl<DownloadhistoryMapper, Downloadhistory> implements IDownloadhistoryService {

    @Autowired
    private RedisTemplate redisTemplate;


    @Override
    public Map<String, Object> downloadHistory(Downloadhistory downloadhistory) {
        String key1 = "token:"+ UUID.randomUUID();
        redisTemplate.opsForValue().set(key1,downloadhistory,30, TimeUnit.MINUTES);
        Map<String,Object> data = new HashMap<>();
        if(key1!=null) {
            data.put("token", key1); //返回数据token
            String key = downloadhistory.toString();
            data.put("result", key);
            return data;
        }else {
            data.put("result","false");
            return data;
        }
    }

    //修改历史记录
    @Override
    public Map<String,Object> UpdateDownloadHistory(Downloadhistory downloadhistory) {
        LambdaQueryWrapper<Downloadhistory> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Downloadhistory::getDlhid,downloadhistory.getDlhid());
        Map<String,Object> data = new HashMap<>();
        if(this.update(downloadhistory,queryWrapper)){
            String key1 = "token:"+ UUID.randomUUID();
            redisTemplate.opsForValue().set(key1,downloadhistory,30, TimeUnit.MINUTES);
            data.put("token",key1); //返回数据token
            data.put("修改后数据信息：",downloadhistory);
            return data;
        }else {
            data.put("result","false");
            return data;
        }
    }


}
