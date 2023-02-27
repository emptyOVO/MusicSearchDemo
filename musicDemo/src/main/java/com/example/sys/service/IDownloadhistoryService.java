package com.example.sys.service;

import com.example.sys.entity.Downloadhistory;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.Map;

/**
 * <p>
 *  Downloadhistory服务类
 * </p>
 *
 * @author feige
 * @since 2023-02-26
 */
public interface IDownloadhistoryService extends IService<Downloadhistory> {
    Map<String, Object> downloadHistory(Downloadhistory downloadhistory);

    Map<String,Object> UpdateDownloadHistory(Downloadhistory downloadhistory);
}
