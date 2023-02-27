package com.example.sys.controller;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.common.vo.Result;
import com.example.sys.entity.Downloadhistory;
import com.example.sys.mapper.DownloadhistoryMapper;
import com.example.sys.service.IDownloadhistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * <p>
 *  DownloadHistory前端控制器
 * </p>
 *
 * @author feige
 * @since 2023-02-26
 */
@RestController
@RequestMapping("/history")
@CrossOrigin
public class DownloadhistoryController {

    @Resource
    private DownloadhistoryMapper downloadhistoryMapper;

    @Autowired
    private IDownloadhistoryService downloadhistoryService;

    @ResponseBody
    @PostMapping("/addHistory")
    //新增历史记录
    public Result<?> addDownloadHistory(@RequestBody Downloadhistory downloadhistory) {
        downloadhistoryService.save(downloadhistory);
        Map<String, Object> data = new HashMap<>();
        data.put("新增历史数据：",downloadhistoryService.downloadHistory(downloadhistory));
        return Result.success(data,"新增历史记录成功");
    }


    //查询全部历史记录列表
   /* @ResponseBody
    @GetMapping("/history")
    public Result<List<Downloadhistory>> getAllUser() {
        List<Downloadhistory> list = downloadhistoryService.list();
        return Result.success(list,"查询成功");
    }*/

    //删除历史记录
    @ResponseBody
    @DeleteMapping ("/delete")
    public Result<?> deleteHistory(Integer dlhid){
        Map<String, Object> data = new HashMap<>();
        data.put("已删除数据",downloadhistoryMapper.selectById(dlhid));
        downloadhistoryMapper.deleteById(dlhid);
        return Result.success(data,"删除历史记录成功");
    }
    //    分页查询
//    接口路径：/history/page?=1(默认pageSize=10)
    @GetMapping("/history")
    public Result<?> list(Integer page){
        Page<Downloadhistory> DownloadHistoryPage = new Page<>(page,10);
        Page<Downloadhistory> ResultPage =new LambdaQueryChainWrapper<>(downloadhistoryService.getBaseMapper()).page(DownloadHistoryPage);
        List<Downloadhistory> records = ResultPage.getRecords();
        return Result.success(records,"查询成功");
    }

    //修改历史记录收藏
    @PutMapping("/update")
    public Result<?> updateHistory(@RequestBody Downloadhistory downloadhistory){
        Map<String,Object>data = downloadhistoryService.UpdateDownloadHistory(downloadhistory);
        return Result.success(data,"修改成功");
    }

}
