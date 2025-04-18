package com.github.nekox41.service;

import java.util.List;
import com.github.nekox41.domain.LongyunImage;

/**
 * 文章图片Service接口
 * 
 * @author aameow
 * @date 2025-04-18
 */
public interface ILongyunImageService 
{
    /**
     * 查询文章图片
     * 
     * @param imageId 文章图片主键
     * @return 文章图片
     */
    public LongyunImage selectLongyunImageByImageId(Long imageId);

    /**
     * 查询文章图片列表
     * 
     * @param longyunImage 文章图片
     * @return 文章图片集合
     */
    public List<LongyunImage> selectLongyunImageList(LongyunImage longyunImage);

    /**
     * 新增文章图片
     * 
     * @param longyunImage 文章图片
     * @return 结果
     */
    public int insertLongyunImage(LongyunImage longyunImage);

    /**
     * 修改文章图片
     * 
     * @param longyunImage 文章图片
     * @return 结果
     */
    public int updateLongyunImage(LongyunImage longyunImage);

    /**
     * 批量删除文章图片
     * 
     * @param imageIds 需要删除的文章图片主键集合
     * @return 结果
     */
    public int deleteLongyunImageByImageIds(Long[] imageIds);

    /**
     * 删除文章图片信息
     * 
     * @param imageId 文章图片主键
     * @return 结果
     */
    public int deleteLongyunImageByImageId(Long imageId);
}
