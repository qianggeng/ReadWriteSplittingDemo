package com.qiang.demo.service;


import com.qiang.common.BaseService;
import com.qiang.demo.entity.Area;

import java.util.List;

/**
 * @author gengqiang
 */
public interface AreaService extends BaseService<Area> {

    /**
     * 插入回滚
     */
    void insertBack();
}
