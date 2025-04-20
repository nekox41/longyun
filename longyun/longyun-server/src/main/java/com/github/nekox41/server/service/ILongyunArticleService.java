package com.github.nekox41.server.service;

import java.util.List;
import com.github.nekox41.server.domain.LongyunArticle;

/**
 * 文章管理Service接口
 * 
 * @author longyun
 * @date 2025-04-20
 */
public interface ILongyunArticleService 
{
    /**
     * 查询文章管理
     * 
     * @param articleId 文章管理主键
     * @return 文章管理
     */
    public LongyunArticle selectLongyunArticleByArticleId(Long articleId);

    /**
     * 查询文章管理列表
     * 
     * @param longyunArticle 文章管理
     * @return 文章管理集合
     */
    public List<LongyunArticle> selectLongyunArticleList(LongyunArticle longyunArticle);

    /**
     * 新增文章管理
     * 
     * @param longyunArticle 文章管理
     * @return 结果
     */
    public int insertLongyunArticle(LongyunArticle longyunArticle);

    /**
     * 修改文章管理
     * 
     * @param longyunArticle 文章管理
     * @return 结果
     */
    public int updateLongyunArticle(LongyunArticle longyunArticle);

    /**
     * 批量删除文章管理
     * 
     * @param articleIds 需要删除的文章管理主键集合
     * @return 结果
     */
    public int deleteLongyunArticleByArticleIds(Long[] articleIds);

    /**
     * 删除文章管理信息
     * 
     * @param articleId 文章管理主键
     * @return 结果
     */
    public int deleteLongyunArticleByArticleId(Long articleId);
}
