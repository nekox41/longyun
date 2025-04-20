package com.github.nekox41.server.service.impl;

import java.util.List;
import com.github.nekox41.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.nekox41.server.mapper.LongyunArticleMapper;
import com.github.nekox41.server.domain.LongyunArticle;
import com.github.nekox41.server.service.ILongyunArticleService;

/**
 * 文章管理Service业务层处理
 * 
 * @author longyun
 * @date 2025-04-20
 */
@Service
public class LongyunArticleServiceImpl implements ILongyunArticleService 
{
    @Autowired
    private LongyunArticleMapper longyunArticleMapper;

    /**
     * 查询文章管理
     * 
     * @param articleId 文章管理主键
     * @return 文章管理
     */
    @Override
    public LongyunArticle selectLongyunArticleByArticleId(Long articleId)
    {
        return longyunArticleMapper.selectLongyunArticleByArticleId(articleId);
    }

    /**
     * 查询文章管理列表
     * 
     * @param longyunArticle 文章管理
     * @return 文章管理
     */
    @Override
    public List<LongyunArticle> selectLongyunArticleList(LongyunArticle longyunArticle)
    {
        return longyunArticleMapper.selectLongyunArticleList(longyunArticle);
    }

    /**
     * 新增文章管理
     * 
     * @param longyunArticle 文章管理
     * @return 结果
     */
    @Override
    public int insertLongyunArticle(LongyunArticle longyunArticle)
    {
        longyunArticle.setCreateTime(DateUtils.getNowDate());
        return longyunArticleMapper.insertLongyunArticle(longyunArticle);
    }

    /**
     * 修改文章管理
     * 
     * @param longyunArticle 文章管理
     * @return 结果
     */
    @Override
    public int updateLongyunArticle(LongyunArticle longyunArticle)
    {
        longyunArticle.setUpdateTime(DateUtils.getNowDate());
        return longyunArticleMapper.updateLongyunArticle(longyunArticle);
    }

    /**
     * 批量删除文章管理
     * 
     * @param articleIds 需要删除的文章管理主键
     * @return 结果
     */
    @Override
    public int deleteLongyunArticleByArticleIds(Long[] articleIds)
    {
        return longyunArticleMapper.deleteLongyunArticleByArticleIds(articleIds);
    }

    /**
     * 删除文章管理信息
     * 
     * @param articleId 文章管理主键
     * @return 结果
     */
    @Override
    public int deleteLongyunArticleByArticleId(Long articleId)
    {
        return longyunArticleMapper.deleteLongyunArticleByArticleId(articleId);
    }
}
