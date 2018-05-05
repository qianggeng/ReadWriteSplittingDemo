package com.qiang.demo.service.impl;

import com.qiang.common.BaseMapper;
import com.qiang.common.BaseServiceImpl;
import com.qiang.demo.entity.Area;
import com.qiang.demo.mapper.AreaMapper;
import com.qiang.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * @author Administrator
 * @date 2016/9/9
 */
@Service
public class AreaServiceImpl extends BaseServiceImpl<Area> implements AreaService {

    @Autowired
    private AreaMapper mapper;

    @Override
    public BaseMapper<Area> getMapper() {
        return mapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertBack() {
        Area area = new Area();
        area.setDistrictId("0000");
        area.setName("test");
        area.setParentId(0);
        area.setLevel(1);
        mapper.insert(area);
        throw new RuntimeException();
    }
}
