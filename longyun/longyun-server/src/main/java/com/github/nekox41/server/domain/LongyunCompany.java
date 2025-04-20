package com.github.nekox41.server.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.github.nekox41.common.annotation.Excel;
import com.github.nekox41.common.core.domain.BaseEntity;

/**
 * 公司信息对象 longyun_company
 * 
 * @author longyun
 * @date 2025-04-20
 */
public class LongyunCompany extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 公司名称 */
    @Excel(name = "公司名称")
    private String companyName;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String companyContact;

    /** 公司介绍 */
    @Excel(name = "公司介绍")
    private String companyDescription;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setCompanyName(String companyName) 
    {
        this.companyName = companyName;
    }

    public String getCompanyName() 
    {
        return companyName;
    }

    public void setCompanyContact(String companyContact) 
    {
        this.companyContact = companyContact;
    }

    public String getCompanyContact() 
    {
        return companyContact;
    }

    public void setCompanyDescription(String companyDescription) 
    {
        this.companyDescription = companyDescription;
    }

    public String getCompanyDescription() 
    {
        return companyDescription;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("companyName", getCompanyName())
            .append("companyContact", getCompanyContact())
            .append("companyDescription", getCompanyDescription())
            .toString();
    }
}
