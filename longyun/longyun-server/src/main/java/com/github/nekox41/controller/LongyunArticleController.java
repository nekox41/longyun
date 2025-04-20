package com.longyun.server.controller;

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
import com.longyun.server.domain.LongyunArticle;
import com.longyun.server.service.ILongyunArticleService;
import com.github.nekox41.common.utils.poi.ExcelUtil;
import com.github.nekox41.common.core.page.TableDataInfo;

/**
 * 文章Controller
 * 
 * @author longyun
 * @date 2025-04-19
 */
@RestController
@RequestMapping("/server/article")
public class LongyunArticleController extends BaseController
{
    @Autowired
    private ILongyunArticleService longyunArticleService;

    /**
     * 查询文章列表
     */
    @PreAuthorize("@ss.hasPermi('server:article:list')")
    @GetMapping("/list")
    public TableDataInfo list(LongyunArticle longyunArticle)
    {
        startPage();
        List<LongyunArticle> list = longyunArticleService.selectLongyunArticleList(longyunArticle);
        return getDataTable(list);
    }

    /**
     * 导出文章列表
     */
    @PreAuthorize("@ss.hasPermi('server:article:export')")
    @Log(title = "文章", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LongyunArticle longyunArticle)
    {
        List<LongyunArticle> list = longyunArticleService.selectLongyunArticleList(longyunArticle);
        ExcelUtil<LongyunArticle> util = new ExcelUtil<LongyunArticle>(LongyunArticle.class);
        util.exportExcel(response, list, "文章数据");
    }

    /**
     * 获取文章详细信息
     */
    @PreAuthorize("@ss.hasPermi('server:article:query')")
    @GetMapping(value = "/{articleId}")
    public AjaxResult getInfo(@PathVariable("articleId") Long articleId)
    {
        return success(longyunArticleService.selectLongyunArticleByArticleId(articleId));
    }

    /**
     * 新增文章
     */
    @PreAuthorize("@ss.hasPermi('server:article:add')")
    @Log(title = "文章", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LongyunArticle longyunArticle)
    {
        return toAjax(longyunArticleService.insertLongyunArticle(longyunArticle));
    }

    /**
     * 修改文章
     */
    @PreAuthorize("@ss.hasPermi('server:article:edit')")
    @Log(title = "文章", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LongyunArticle longyunArticle)
    {
        return toAjax(longyunArticleService.updateLongyunArticle(longyunArticle));
    }

    /**
     * 删除文章
     */
    @PreAuthorize("@ss.hasPermi('server:article:remove')")
    @Log(title = "文章", businessType = BusinessType.DELETE)
	@DeleteMapping("/{articleIds}")
    public AjaxResult remove(@PathVariable Long[] articleIds)
    {
        return toAjax(longyunArticleService.deleteLongyunArticleByArticleIds(articleIds));
    }
}
