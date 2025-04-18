package com.github.nekox41.service.impl;

import java.util.List;
import com.github.nekox41.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.nekox41.mapper.LongyunImageMapper;
import com.github.nekox41.domain.LongyunImage;
import com.github.nekox41.service.ILongyunImageService;

/**
 * 文章图片Service业务层处理
 * 
 * @author aameow
 * @date 2025-04-18
 */
@Service
public class LongyunImageServiceImpl implements ILongyunImageService 
{
    @Autowired
    private LongyunImageMapper longyunImageMapper;

    /**
     * 查询文章图片
     * 
     * @param imageId 文章图片主键
     * @return 文章图片
     */
    @Override
    public LongyunImage selectLongyunImageByImageId(Long imageId)
    {
        return longyunImageMapper.selectLongyunImageByImageId(imageId);
    }

    /**
     * 查询文章图片列表
     * 
     * @param longyunImage 文章图片
     * @return 文章图片
     */
    @Override
    public List<LongyunImage> selectLongyunImageList(LongyunImage longyunImage)
    {
        return longyunImageMapper.selectLongyunImageList(longyunImage);
    }

    /**
     * 新增文章图片
     * 
     * @param longyunImage 文章图片
     * @return 结果
     */
    @Override
    public int insertLongyunImage(LongyunImage longyunImage)
    {
        longyunImage.setCreateTime(DateUtils.getNowDate());
        return longyunImageMapper.insertLongyunImage(longyunImage);
    }

    /**
     * 修改文章图片
     * 
     * @param longyunImage 文章图片
     * @return 结果
     */
    @Override
    public int updateLongyunImage(LongyunImage longyunImage)
    {
        longyunImage.setUpdateTime(DateUtils.getNowDate());
        return longyunImageMapper.updateLongyunImage(longyunImage);
    }

    /**
     * 批量删除文章图片
     * 
     * @param imageIds 需要删除的文章图片主键
     * @return 结果
     */
    @Override
    public int deleteLongyunImageByImageIds(Long[] imageIds)
    {
        return longyunImageMapper.deleteLongyunImageByImageIds(imageIds);
    }

    /**
     * 删除文章图片信息
     * 
     * @param imageId 文章图片主键
     * @return 结果
     */
    @Override
    public int deleteLongyunImageByImageId(Long imageId)
    {
        return longyunImageMapper.deleteLongyunImageByImageId(imageId);
    }
}
