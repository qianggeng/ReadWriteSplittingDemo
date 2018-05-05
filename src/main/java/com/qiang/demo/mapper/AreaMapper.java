package com.qiang.demo.mapper;

import com.qiang.common.BaseMapper;
import com.qiang.demo.entity.Area;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Administrator
 * @date 2016/9/8
 */
public interface AreaMapper extends BaseMapper<Area> {

    List<Area> selectByParentId(@Param("parentId") Integer parentId);

    List<Area> selectAreaIdByName(@Param("name") String name);

    String getDepCode(@Param("areaId") Integer areaId);

    String getAreaName(@Param("areaId") Integer areaId);

    Area findByDepCode(@Param("code") String code);
}
