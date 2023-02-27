
package com.example.musicdemo.CodeGenerator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class CodeGenerator {
    public static void main(String[] args) {
        String url = "jdbc:mysql:///music?useSSL=false&useUnicode=true&characterEncoding=utf8";
        String username = "root";
        String password = "123456";
        String author = "feige";
        String outputDir = "D:\\idea\\musicDemo\\src\\main\\java";
        String basePackage = "com.example";
        String moduleName = "sys";
        String mapperLocation = "D:\\idea\\musicDemo\\src\\main\\resources\\mapper\\" + moduleName;
        String tableName = "downloadhistory,searchs,user";
        FastAutoGenerator.create(url, username, password).globalConfig(builder -> {
            builder.author(author) // 设置作者
                     .outputDir(outputDir); // 指定输出目录
             }).packageConfig(builder -> {
                 builder.parent(basePackage) // 父包名
                         .moduleName(moduleName) // 父包模块名
                         .pathInfo(Collections.singletonMap(OutputFile.xml, mapperLocation)); // mapperXml生成路径
             })
                .strategyConfig(builder -> {
                    builder.addInclude(tableName); // 需要生成的表名
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认Velocity引擎模板
         .execute();
        }

    }

