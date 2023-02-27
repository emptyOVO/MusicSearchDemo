package com.example.sys.controller;

import com.example.common.vo.Result;
import com.example.sys.entity.Searchs;
import com.example.sys.service.ISearchesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


/**
 * <p>
 *  Search前端控制器
 * </p>
 *
 * @author feige
 * @since 2023-02-26
 */
@RestController
@RequestMapping("/search")
@CrossOrigin
public class SearchsController {

    @Autowired
    private ISearchesService searchesService;

    @Resource
    private ISearchesService searches;

    //搜索功能
    @ResponseBody
    @GetMapping("/search")
    public Result<Map<String, Object>> search(String text) {
        Map<String, Object> data = searches.search(text);
        return Result.success(data);
    }

    //TODO：待完善，与search对接使得查询的结果返回到searchList里面并上传保存至持久层

    //添加搜索记录
    @ResponseBody
    @PostMapping("/searchList")
    public Result<?> searchList(@RequestBody Searchs searchs) {
        searchesService.save(searchs);
        Map<String, Object> data = searchesService.searchlist(searchs);
        searchesService.list();
        return Result.success(data,"添加成功");
    }

    //TODO：根据搜索得到的rid得到真实mp3文件url，并且在下载后将歌曲存入历史记录

    //下载文件
    @GetMapping ("/download")
    public String download(HttpServletResponse response, String fileName) {
        searchesService.download(response, fileName);
        return fileName;
    }

}
