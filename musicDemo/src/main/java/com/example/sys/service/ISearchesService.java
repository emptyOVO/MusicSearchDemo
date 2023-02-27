package com.example.sys.service;

import com.example.sys.entity.Searchs;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * <p>
 *  Searches服务类
 * </p>
 *
 * @author feige
 * @since 2023-02-26
 */
public interface ISearchesService extends IService<Searchs> {


     Map<String, Object> search(String text);

    Map<String, Object> searchlist(Searchs searchs);

    void download(HttpServletResponse response, String fileName);
}
