package com.github.nekox41.server.mapper;

import java.util.List;
import com.github.nekox41.server.domain.LongyunCompany;

/**
 * 公司信息Mapper接口
 * 
 * @author longyun
 * @date 2025-04-20
 */
public interface LongyunCompanyMapper 
{
    /**
     * 查询公司信息
     * 
     * @param id 公司信息主键
     * @return 公司信息
     */
    public LongyunCompany selectLongyunCompanyById(Long id);

    /**
     * 查询公司信息列表
     * 
     * @param longyunCompany 公司信息
     * @return 公司信息集合
     */
    public List<LongyunCompany> selectLongyunCompanyList(LongyunCompany longyunCompany);

    /**
     * 新增公司信息
     * 
     * @param longyunCompany 公司信息
     * @return 结果
     */
    public int insertLongyunCompany(LongyunCompany longyunCompany);

    /**
     * 修改公司信息
     * 
     * @param longyunCompany 公司信息
     * @return 结果
     */
    public int updateLongyunCompany(LongyunCompany longyunCompany);

    /**
     * 删除公司信息
     * 
     * @param id 公司信息主键
     * @return 结果
     */
    public int deleteLongyunCompanyById(Long id);

    /**
     * 批量删除公司信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLongyunCompanyByIds(Long[] ids);
}
