package com.github.nekox41.server.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.github.nekox41.common.annotation.Excel;
import com.github.nekox41.common.core.domain.BaseEntity;

/**
 * 车队管理对象 longyun_fleet
 * 
 * @author longyun
 * @date 2025-04-20
 */
public class LongyunFleet extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 车队名称 */
    @Excel(name = "车队名称")
    private String fleetName;

    /** 车队图片 */
    @Excel(name = "车队图片")
    private String images;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String contact;

    /** 车队介绍 */
    @Excel(name = "车队介绍")
    private String description;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setFleetName(String fleetName) 
    {
        this.fleetName = fleetName;
    }

    public String getFleetName() 
    {
        return fleetName;
    }

    public void setImages(String images) 
    {
        this.images = images;
    }

    public String getImages() 
    {
        return images;
    }

    public void setContact(String contact) 
    {
        this.contact = contact;
    }

    public String getContact() 
    {
        return contact;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("fleetName", getFleetName())
            .append("images", getImages())
            .append("contact", getContact())
            .append("description", getDescription())
            .toString();
    }
}
