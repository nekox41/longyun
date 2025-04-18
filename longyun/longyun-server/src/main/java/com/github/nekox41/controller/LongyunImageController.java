package com.github.nekox41.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.github.nekox41.domain.LongyunImage;
import com.github.nekox41.service.ILongyunImageService;
import com.github.nekox41.common.utils.poi.ExcelUtil;
import com.github.nekox41.common.core.page.TableDataInfo;

/**
 * 文章图片Controller
 * 
 * @author aameow
 * @date 2025-04-18
 */
@RestController
@RequestMapping("/server/image")
public class LongyunImageController extends BaseController
{
    @Autowired
    private ILongyunImageService longyunImageService;

    /**
     * 查询文章图片列表
     */
    @PreAuthorize("@ss.hasPermi('server:image:list')")
    @GetMapping("/list")
    public TableDataInfo list(LongyunImage longyunImage)
    {
        startPage();
        List<LongyunImage> list = longyunImageService.selectLongyunImageList(longyunImage);
        return getDataTable(list);
    }

    /**
     * 导出文章图片列表
     */
    @PreAuthorize("@ss.hasPermi('server:image:export')")
    @Log(title = "文章图片", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LongyunImage longyunImage)
    {
        List<LongyunImage> list = longyunImageService.selectLongyunImageList(longyunImage);
        ExcelUtil<LongyunImage> util = new ExcelUtil<LongyunImage>(LongyunImage.class);
        util.exportExcel(response, list, "文章图片数据");
    }

    /**
     * 获取文章图片详细信息
     */
    @PreAuthorize("@ss.hasPermi('server:image:query')")
    @GetMapping(value = "/{imageId}")
    public AjaxResult getInfo(@PathVariable("imageId") Long imageId)
    {
        return success(longyunImageService.selectLongyunImageByImageId(imageId));
    }

    /**
     * 新增文章图片
     */
    @PreAuthorize("@ss.hasPermi('server:image:add')")
    @Log(title = "文章图片", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LongyunImage longyunImage)
    {
        return toAjax(longyunImageService.insertLongyunImage(longyunImage));
    }

    /**
     * 修改文章图片
     */
    @PreAuthorize("@ss.hasPermi('server:image:edit')")
    @Log(title = "文章图片", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LongyunImage longyunImage)
    {
        return toAjax(longyunImageService.updateLongyunImage(longyunImage));
    }

    /**
     * 删除文章图片
     */
    @PreAuthorize("@ss.hasPermi('server:image:remove')")
    @Log(title = "文章图片", businessType = BusinessType.DELETE)
	@DeleteMapping("/{imageIds}")
    public AjaxResult remove(@PathVariable Long[] imageIds)
    {
        return toAjax(longyunImageService.deleteLongyunImageByImageIds(imageIds));
    }
}
