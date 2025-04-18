package com.github.nekox41.mapper;

import java.util.List;
import com.github.nekox41.domain.LongyunImage;

/**
 * 文章图片Mapper接口
 * 
 * @author aameow
 * @date 2025-04-18
 */
public interface LongyunImageMapper 
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
     * 删除文章图片
     * 
     * @param imageId 文章图片主键
     * @return 结果
     */
    public int deleteLongyunImageByImageId(Long imageId);

    /**
     * 批量删除文章图片
     * 
     * @param imageIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLongyunImageByImageIds(Long[] imageIds);
}
