package com.example.musicdemo.MyTests;

import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class TestRestTemplate {
    public static void main(String[] args) {
        Map<String, String> vars = new HashMap<>();
        String url = "https://search.kuwo.cn/r.s?all={name}&ft=music&rn={num}&rformat=json&encoding=utf8";
        vars.put("name", "周杰伦");
        vars.put("num", "10");
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class, vars);
        System.out.println(result);
    }
}
