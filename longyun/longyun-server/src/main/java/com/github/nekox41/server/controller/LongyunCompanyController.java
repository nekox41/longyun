package com.github.nekox41.server.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.github.nekox41.common.annotation.Anonymous;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.github.nekox41.common.annotation.Log;
import com.github.nekox41.common.core.controller.BaseController;
import com.github.nekox41.common.core.domain.AjaxResult;
import com.github.nekox41.common.enums.BusinessType;
import com.github.nekox41.server.domain.LongyunCompany;
import com.github.nekox41.server.service.ILongyunCompanyService;
import com.github.nekox41.common.utils.poi.ExcelUtil;
import com.github.nekox41.common.core.page.TableDataInfo;

/**
 * 公司信息Controller
 * 
 * @author longyun
 * @date 2025-04-20
 */
@RestController
@RequestMapping("/server/company")
public class LongyunCompanyController extends BaseController
{
    @Autowired
    private ILongyunCompanyService longyunCompanyService;

    /**
     * 查询公司信息列表
     */
    @PreAuthorize("@ss.hasPermi('server:company:list')")
    @GetMapping("/list")
    public TableDataInfo list(LongyunCompany longyunCompany)
    {
        startPage();
        List<LongyunCompany> list = longyunCompanyService.selectLongyunCompanyList(longyunCompany);
        return getDataTable(list);
    }

    /**
     * 导出公司信息列表
     */
    @PreAuthorize("@ss.hasPermi('server:company:export')")
    @Log(title = "公司信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LongyunCompany longyunCompany)
    {
        List<LongyunCompany> list = longyunCompanyService.selectLongyunCompanyList(longyunCompany);
        ExcelUtil<LongyunCompany> util = new ExcelUtil<LongyunCompany>(LongyunCompany.class);
        util.exportExcel(response, list, "公司信息数据");
    }

    /**
     * 获取公司信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('server:company:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(longyunCompanyService.selectLongyunCompanyById(id));
    }

    /**
     * 新增公司信息
     */
    @PreAuthorize("@ss.hasPermi('server:company:add')")
    @Log(title = "公司信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LongyunCompany longyunCompany)
    {
        return toAjax(longyunCompanyService.insertLongyunCompany(longyunCompany));
    }

    /**
     * 修改公司信息
     */
    @PreAuthorize("@ss.hasPermi('server:company:edit')")
    @Log(title = "公司信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LongyunCompany longyunCompany)
    {
        return toAjax(longyunCompanyService.updateLongyunCompany(longyunCompany));
    }

    /**
     * 删除公司信息
     */
    @PreAuthorize("@ss.hasPermi('server:company:remove')")
    @Log(title = "公司信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(longyunCompanyService.deleteLongyunCompanyByIds(ids));
    }

    /**
     * 获取公司信息详细信息
     */
    @Anonymous
    @GetMapping(value = "/info")
    public AjaxResult getInfo()
    {
        return success(longyunCompanyService.selectLongyunCompanyById(1L));
    }
}
