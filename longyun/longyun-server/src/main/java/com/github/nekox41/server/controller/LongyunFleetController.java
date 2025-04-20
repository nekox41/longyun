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
import com.github.nekox41.server.domain.LongyunFleet;
import com.github.nekox41.server.service.ILongyunFleetService;
import com.github.nekox41.common.utils.poi.ExcelUtil;
import com.github.nekox41.common.core.page.TableDataInfo;

/**
 * 车队管理Controller
 * 
 * @author longyun
 * @date 2025-04-20
 */
@RestController
@RequestMapping("/server/fleet")
public class LongyunFleetController extends BaseController
{
    @Autowired
    private ILongyunFleetService longyunFleetService;

    /**
     * 查询车队管理列表
     */
    @Anonymous
    @GetMapping("/list")
    public TableDataInfo list(LongyunFleet longyunFleet)
    {
        startPage();
        List<LongyunFleet> list = longyunFleetService.selectLongyunFleetList(longyunFleet);
        return getDataTable(list);
    }

    /**
     * 导出车队管理列表
     */
    @PreAuthorize("@ss.hasPermi('server:fleet:export')")
    @Log(title = "车队管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LongyunFleet longyunFleet)
    {
        List<LongyunFleet> list = longyunFleetService.selectLongyunFleetList(longyunFleet);
        ExcelUtil<LongyunFleet> util = new ExcelUtil<LongyunFleet>(LongyunFleet.class);
        util.exportExcel(response, list, "车队管理数据");
    }

    /**
     * 获取车队管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('server:fleet:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(longyunFleetService.selectLongyunFleetById(id));
    }

    /**
     * 新增车队管理
     */
    @PreAuthorize("@ss.hasPermi('server:fleet:add')")
    @Log(title = "车队管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LongyunFleet longyunFleet)
    {
        return toAjax(longyunFleetService.insertLongyunFleet(longyunFleet));
    }

    /**
     * 修改车队管理
     */
    @PreAuthorize("@ss.hasPermi('server:fleet:edit')")
    @Log(title = "车队管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LongyunFleet longyunFleet)
    {
        return toAjax(longyunFleetService.updateLongyunFleet(longyunFleet));
    }

    /**
     * 删除车队管理
     */
    @PreAuthorize("@ss.hasPermi('server:fleet:remove')")
    @Log(title = "车队管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(longyunFleetService.deleteLongyunFleetByIds(ids));
    }
}
