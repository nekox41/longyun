package com.github.nekox41.server.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.nekox41.server.mapper.LongyunFleetMapper;
import com.github.nekox41.server.domain.LongyunFleet;
import com.github.nekox41.server.service.ILongyunFleetService;

/**
 * 车队管理Service业务层处理
 * 
 * @author longyun
 * @date 2025-04-20
 */
@Service
public class LongyunFleetServiceImpl implements ILongyunFleetService 
{
    @Autowired
    private LongyunFleetMapper longyunFleetMapper;

    /**
     * 查询车队管理
     * 
     * @param id 车队管理主键
     * @return 车队管理
     */
    @Override
    public LongyunFleet selectLongyunFleetById(Long id)
    {
        return longyunFleetMapper.selectLongyunFleetById(id);
    }

    /**
     * 查询车队管理列表
     * 
     * @param longyunFleet 车队管理
     * @return 车队管理
     */
    @Override
    public List<LongyunFleet> selectLongyunFleetList(LongyunFleet longyunFleet)
    {
        return longyunFleetMapper.selectLongyunFleetList(longyunFleet);
    }

    /**
     * 新增车队管理
     * 
     * @param longyunFleet 车队管理
     * @return 结果
     */
    @Override
    public int insertLongyunFleet(LongyunFleet longyunFleet)
    {
        return longyunFleetMapper.insertLongyunFleet(longyunFleet);
    }

    /**
     * 修改车队管理
     * 
     * @param longyunFleet 车队管理
     * @return 结果
     */
    @Override
    public int updateLongyunFleet(LongyunFleet longyunFleet)
    {
        return longyunFleetMapper.updateLongyunFleet(longyunFleet);
    }

    /**
     * 批量删除车队管理
     * 
     * @param ids 需要删除的车队管理主键
     * @return 结果
     */
    @Override
    public int deleteLongyunFleetByIds(Long[] ids)
    {
        return longyunFleetMapper.deleteLongyunFleetByIds(ids);
    }

    /**
     * 删除车队管理信息
     * 
     * @param id 车队管理主键
     * @return 结果
     */
    @Override
    public int deleteLongyunFleetById(Long id)
    {
        return longyunFleetMapper.deleteLongyunFleetById(id);
    }
}
