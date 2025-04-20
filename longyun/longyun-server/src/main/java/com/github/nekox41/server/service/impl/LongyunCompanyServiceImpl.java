package com.github.nekox41.server.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.nekox41.server.mapper.LongyunCompanyMapper;
import com.github.nekox41.server.domain.LongyunCompany;
import com.github.nekox41.server.service.ILongyunCompanyService;

/**
 * 公司信息Service业务层处理
 * 
 * @author longyun
 * @date 2025-04-20
 */
@Service
public class LongyunCompanyServiceImpl implements ILongyunCompanyService 
{
    @Autowired
    private LongyunCompanyMapper longyunCompanyMapper;

    /**
     * 查询公司信息
     * 
     * @param id 公司信息主键
     * @return 公司信息
     */
    @Override
    public LongyunCompany selectLongyunCompanyById(Long id)
    {
        return longyunCompanyMapper.selectLongyunCompanyById(id);
    }

    /**
     * 查询公司信息列表
     * 
     * @param longyunCompany 公司信息
     * @return 公司信息
     */
    @Override
    public List<LongyunCompany> selectLongyunCompanyList(LongyunCompany longyunCompany)
    {
        return longyunCompanyMapper.selectLongyunCompanyList(longyunCompany);
    }

    /**
     * 新增公司信息
     * 
     * @param longyunCompany 公司信息
     * @return 结果
     */
    @Override
    public int insertLongyunCompany(LongyunCompany longyunCompany)
    {
        return longyunCompanyMapper.insertLongyunCompany(longyunCompany);
    }

    /**
     * 修改公司信息
     * 
     * @param longyunCompany 公司信息
     * @return 结果
     */
    @Override
    public int updateLongyunCompany(LongyunCompany longyunCompany)
    {
        return longyunCompanyMapper.updateLongyunCompany(longyunCompany);
    }

    /**
     * 批量删除公司信息
     * 
     * @param ids 需要删除的公司信息主键
     * @return 结果
     */
    @Override
    public int deleteLongyunCompanyByIds(Long[] ids)
    {
        return longyunCompanyMapper.deleteLongyunCompanyByIds(ids);
    }

    /**
     * 删除公司信息信息
     * 
     * @param id 公司信息主键
     * @return 结果
     */
    @Override
    public int deleteLongyunCompanyById(Long id)
    {
        return longyunCompanyMapper.deleteLongyunCompanyById(id);
    }
}
