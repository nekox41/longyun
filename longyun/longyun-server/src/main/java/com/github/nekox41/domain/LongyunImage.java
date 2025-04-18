package com.github.nekox41.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.github.nekox41.common.annotation.Excel;
import com.github.nekox41.common.core.domain.BaseEntity;

/**
 * 文章图片对象 longyun_image
 * 
 * @author aameow
 * @date 2025-04-18
 */
public class LongyunImage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 图片ID */
    @Excel(name = "图片ID")
    private Long imageId;

    /** 关联文章ID */
    @Excel(name = "关联文章ID")
    private Long articleId;

    /** 图片名字 */
    @Excel(name = "图片名字")
    private String imageName;

    /** 图片链接 */
    @Excel(name = "图片链接")
    private String imageUrl;

    public void setImageId(Long imageId) 
    {
        this.imageId = imageId;
    }

    public Long getImageId() 
    {
        return imageId;
    }

    public void setArticleId(Long articleId) 
    {
        this.articleId = articleId;
    }

    public Long getArticleId() 
    {
        return articleId;
    }

    public void setImageName(String imageName) 
    {
        this.imageName = imageName;
    }

    public String getImageName() 
    {
        return imageName;
    }

    public void setImageUrl(String imageUrl) 
    {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() 
    {
        return imageUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("imageId", getImageId())
            .append("articleId", getArticleId())
            .append("imageName", getImageName())
            .append("imageUrl", getImageUrl())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
