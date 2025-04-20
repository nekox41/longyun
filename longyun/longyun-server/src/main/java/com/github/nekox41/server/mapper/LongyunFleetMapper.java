package com.github.nekox41.server.mapper;

import java.util.List;
import com.github.nekox41.server.domain.LongyunFleet;

/**
 * 车队管理Mapper接口
 * 
 * @author longyun
 * @date 2025-04-20
 */
public interface LongyunFleetMapper 
{
    /**
     * 查询车队管理
     * 
     * @param id 车队管理主键
     * @return 车队管理
     */
    public LongyunFleet selectLongyunFleetById(Long id);

    /**
     * 查询车队管理列表
     * 
     * @param longyunFleet 车队管理
     * @return 车队管理集合
     */
    public List<LongyunFleet> selectLongyunFleetList(LongyunFleet longyunFleet);

    /**
     * 新增车队管理
     * 
     * @param longyunFleet 车队管理
     * @return 结果
     */
    public int insertLongyunFleet(LongyunFleet longyunFleet);

    /**
     * 修改车队管理
     * 
     * @param longyunFleet 车队管理
     * @return 结果
     */
    public int updateLongyunFleet(LongyunFleet longyunFleet);

    /**
     * 删除车队管理
     * 
     * @param id 车队管理主键
     * @return 结果
     */
    public int deleteLongyunFleetById(Long id);

    /**
     * 批量删除车队管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLongyunFleetByIds(Long[] ids);
}
