package com.example.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.sys.entity.Searchs;
import com.example.sys.entity.User;
import com.example.sys.mapper.SearchesMapper;
import com.example.sys.service.ISearchesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 *  Searches服务实现类
 * </p>
 *
 * @author feige
 * @since 2023-02-26
 */

@Service
public class SearchesServiceImpl extends ServiceImpl<SearchesMapper, Searchs> implements ISearchesService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RedisTemplate redisTemplate;


    @Override
    public Map<String, Object> search(String text) {

        Map<String, String> vars = new HashMap<>();
        String url = "https://search.kuwo.cn/r.s?all={name}&ft=music& itemset=web_2022&client=kt&rformat=json&encoding=utf8";
        vars.put("name", text);
        //调用api返回json字符串
        String result = this.restTemplate.getForObject(url, String.class, vars);
        //JSONObject jsonObject = JSON.parseObject(result);

        Pattern change1 = Pattern.compile("ARTIST");
        Matcher matcher1 = change1.matcher(result);
        String result2 = matcher1.replaceAll("ssinger");
        Pattern change2 = Pattern.compile("NAME");
        Matcher matcher2 = change2.matcher(result2);
        String result3 = matcher2.replaceAll("ssong");
        Pattern change3 = Pattern.compile("ALBUM");
        Matcher matcher3 = change3.matcher(result3);
        String result4 = matcher3.replaceAll("salbum");

        Map<String,Object> data = new HashMap<>();
        String key1 = "token:"+ UUID.randomUUID();
        if(key1!=null) {
            redisTemplate.opsForValue().set(key1, text, 30, TimeUnit.MINUTES);
            data.put("token", key1);
            data.put("list", result4);
            System.out.println(result4);
            return data;
        }else {
            data.put("list","false");
            return data;
        }
    }

    @Override
    public Map<String, Object> searchlist(Searchs searchs) {
        String key1 = "token:"+ UUID.randomUUID();
        Map<String, Object> data = new HashMap<>();
        if(key1!=null) {
            redisTemplate.opsForValue().set(key1, searchs, 30, TimeUnit.MINUTES);
            data.put("token", key1);
            String key2 = searchs.toString();
            data.put("result", key2);
            return data;
        }else {
            data.put("result","false");
            return data;
        }
    }

    //TODO:下载方法待完善

    //下载文件
    @Override
    public void download(HttpServletResponse response, String fileName) {
        if (fileName != null){
            String realPath = "D:\\kuwo音乐下载";
            File file = new File(realPath,fileName);
            fileName = new String(file.getName().getBytes(StandardCharsets.UTF_8));
            String suffixNmae = fileName.substring(fileName.lastIndexOf("."));
            String uuid = UUID.randomUUID().toString().replaceAll("-","").substring(0,32);
            fileName = uuid + suffixNmae;
            if (file.exists()){
                response.setContentType("application/force-download");
                response.addHeader("Content-Disposition","attachment;fileName="+fileName);
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try{
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while(i != -1){
                        os.write(buffer,0,i);
                        i = bis.read(buffer);
                    }
                    System.out.println("success");
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    if (bis != null){
                        try{
                            bis.close();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                    if (fis != null){
                        try{
                            fis.close();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        System.out.println(fileName);
    }

}
