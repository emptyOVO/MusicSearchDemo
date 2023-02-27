package com.example.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.sys.entity.Downloadhistory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  DownloadhistoryMapper 接口
 * </p>
 *
 * @author feige
 * @since 2023-02-26
 */

@Mapper
@Repository
public interface DownloadhistoryMapper extends BaseMapper<Downloadhistory> {
}



