package com.school.project.teach.exam.controller;

import java.util.List;

import com.school.common.utils.poi.ExcelUtil;
import com.school.framework.aspectj.lang.annotation.Log;
import com.school.framework.aspectj.lang.enums.BusinessType;
import com.school.framework.web.controller.BaseController;
import com.school.framework.web.domain.AjaxResult;
import com.school.framework.web.page.TableDataInfo;
import com.school.project.teach.exam.domain.TExam;
import com.school.project.teach.exam.service.ITExamService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 试卷管理 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-03-10
 */
@Controller
@RequestMapping("/teach/exam")
public class TExamController extends BaseController
{
    private String prefix = "teach/exampaper";
	
	@Autowired
	private ITExamService tExamService;
	
	@RequiresPermissions("system:exam:view")
	@GetMapping()
	public String tExam()
	{
	    return prefix + "/tExam";
	}
	
	/**
	 * 查询试卷管理列表
	 */
	@RequiresPermissions("system:exam:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TExam tExam)
	{
		startPage();
        List<TExam> list = tExamService.selectTExamList(tExam);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出试卷管理列表
	 */
	@RequiresPermissions("system:exam:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TExam tExam)
    {
    	List<TExam> list = tExamService.selectTExamList(tExam);
        ExcelUtil<TExam> util = new ExcelUtil<TExam>(TExam.class);
        return util.exportExcel(list, "tExam");
    }
	
	/**
	 * 新增试卷管理
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存试卷管理
	 */
	@RequiresPermissions("system:exam:add")
	@Log(title = "试卷管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TExam tExam,int xnum, int xsrore, int pnum, int psrore)
	{
		int ok = tExamService.insertTExam(tExam, xnum, xsrore, pnum, psrore);
		return toAjax(ok);
	}

	/**
	 * 修改试卷管理
	 */
	@GetMapping("/edit/{eId}")
	public String edit(@PathVariable("eId") String eId, ModelMap mmap)
	{
		TExam tExam = tExamService.selectTExamById(eId);
		mmap.put("tExam", tExam);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存试卷管理
	 */
	@RequiresPermissions("system:exam:edit")
	@Log(title = "试卷管理", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TExam tExam)
	{		
		return toAjax(tExamService.updateTExam(tExam));
	}
	
	/**
	 * 删除试卷管理
	 */
	@RequiresPermissions("system:exam:remove")
	@Log(title = "试卷管理", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tExamService.deleteTExamByIds(ids));
	}
	
}
