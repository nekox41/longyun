package com.longyun.server.service.impl;

import java.util.List;
import com.github.nekox41.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.longyun.server.mapper.LongyunArticleMapper;
import com.longyun.server.domain.LongyunArticle;
import com.longyun.server.service.ILongyunArticleService;

/**
 * 文章Service业务层处理
 * 
 * @author longyun
 * @date 2025-04-19
 */
@Service
public class LongyunArticleServiceImpl implements ILongyunArticleService 
{
    @Autowired
    private LongyunArticleMapper longyunArticleMapper;

    /**
     * 查询文章
     * 
     * @param articleId 文章主键
     * @return 文章
     */
    @Override
    public LongyunArticle selectLongyunArticleByArticleId(Long articleId)
    {
        return longyunArticleMapper.selectLongyunArticleByArticleId(articleId);
    }

    /**
     * 查询文章列表
     * 
     * @param longyunArticle 文章
     * @return 文章
     */
    @Override
    public List<LongyunArticle> selectLongyunArticleList(LongyunArticle longyunArticle)
    {
        return longyunArticleMapper.selectLongyunArticleList(longyunArticle);
    }

    /**
     * 新增文章
     * 
     * @param longyunArticle 文章
     * @return 结果
     */
    @Override
    public int insertLongyunArticle(LongyunArticle longyunArticle)
    {
        longyunArticle.setCreateTime(DateUtils.getNowDate());
        return longyunArticleMapper.insertLongyunArticle(longyunArticle);
    }

    /**
     * 修改文章
     * 
     * @param longyunArticle 文章
     * @return 结果
     */
    @Override
    public int updateLongyunArticle(LongyunArticle longyunArticle)
    {
        longyunArticle.setUpdateTime(DateUtils.getNowDate());
        return longyunArticleMapper.updateLongyunArticle(longyunArticle);
    }

    /**
     * 批量删除文章
     * 
     * @param articleIds 需要删除的文章主键
     * @return 结果
     */
    @Override
    public int deleteLongyunArticleByArticleIds(Long[] articleIds)
    {
        return longyunArticleMapper.deleteLongyunArticleByArticleIds(articleIds);
    }

    /**
     * 删除文章信息
     * 
     * @param articleId 文章主键
     * @return 结果
     */
    @Override
    public int deleteLongyunArticleByArticleId(Long articleId)
    {
        return longyunArticleMapper.deleteLongyunArticleByArticleId(articleId);
    }
}
