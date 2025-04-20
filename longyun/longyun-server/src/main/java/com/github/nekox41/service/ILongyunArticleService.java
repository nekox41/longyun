package com.longyun.server.service;

import java.util.List;
import com.longyun.server.domain.LongyunArticle;

/**
 * 文章Service接口
 * 
 * @author longyun
 * @date 2025-04-19
 */
public interface ILongyunArticleService 
{
    /**
     * 查询文章
     * 
     * @param articleId 文章主键
     * @return 文章
     */
    public LongyunArticle selectLongyunArticleByArticleId(Long articleId);

    /**
     * 查询文章列表
     * 
     * @param longyunArticle 文章
     * @return 文章集合
     */
    public List<LongyunArticle> selectLongyunArticleList(LongyunArticle longyunArticle);

    /**
     * 新增文章
     * 
     * @param longyunArticle 文章
     * @return 结果
     */
    public int insertLongyunArticle(LongyunArticle longyunArticle);

    /**
     * 修改文章
     * 
     * @param longyunArticle 文章
     * @return 结果
     */
    public int updateLongyunArticle(LongyunArticle longyunArticle);

    /**
     * 批量删除文章
     * 
     * @param articleIds 需要删除的文章主键集合
     * @return 结果
     */
    public int deleteLongyunArticleByArticleIds(Long[] articleIds);

    /**
     * 删除文章信息
     * 
     * @param articleId 文章主键
     * @return 结果
     */
    public int deleteLongyunArticleByArticleId(Long articleId);
}
