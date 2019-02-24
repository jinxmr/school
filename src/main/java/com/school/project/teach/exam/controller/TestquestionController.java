package com.school.project.teach.exam.controller;

import java.util.List;

import com.school.common.utils.poi.ExcelUtil;
import com.school.framework.aspectj.lang.annotation.Log;
import com.school.framework.aspectj.lang.enums.BusinessType;
import com.school.framework.web.controller.BaseController;
import com.school.framework.web.domain.AjaxResult;
import com.school.framework.web.page.TableDataInfo;
import com.school.project.teach.exam.domain.Testquestion;
import com.school.project.teach.exam.service.TestquestionService;
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
 * 试题管理 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-02-23
 */
@Controller
@RequestMapping("/exam/tTestquestion")
public class TestquestionController extends BaseController
{
    private String prefix = "teach/exam";
	
	@Autowired
	private TestquestionService tTestquestionService;
	
	@RequiresPermissions("exam:tTestquestion:view")
	@GetMapping()
	public String tTestquestion()
	{
	    return prefix + "/tTestquestion";
	}
	
	/**
	 * 查询试题管理列表
	 */
	@RequiresPermissions("exam:tTestquestion:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Testquestion tTestquestion)
	{
		startPage();
        List<Testquestion> list = tTestquestionService.selectTTestquestionList(tTestquestion);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出试题管理列表
	 */
	@RequiresPermissions("exam:tTestquestion:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Testquestion tTestquestion)
    {
    	List<Testquestion> list = tTestquestionService.selectTTestquestionList(tTestquestion);
        ExcelUtil<Testquestion> util = new ExcelUtil<Testquestion>(Testquestion.class);
        return util.exportExcel(list, "tTestquestion");
    }
	
	/**
	 * 新增试题管理
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存试题管理
	 */
	@RequiresPermissions("exam:tTestquestion:add")
	@Log(title = "试题管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Testquestion tTestquestion)
	{		
		return toAjax(tTestquestionService.insertTTestquestion(tTestquestion));
	}

	/**
	 * 修改试题管理
	 */
	@GetMapping("/edit/{qId}")
	public String edit(@PathVariable("qId") Integer qId, ModelMap mmap)
	{
		Testquestion tTestquestion = tTestquestionService.selectTTestquestionById(qId);
		mmap.put("tTestquestion", tTestquestion);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存试题管理
	 */
	@RequiresPermissions("exam:tTestquestion:edit")
	@Log(title = "试题管理", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Testquestion tTestquestion)
	{		
		return toAjax(tTestquestionService.updateTTestquestion(tTestquestion));
	}
	
	/**
	 * 删除试题管理
	 */
	@RequiresPermissions("exam:tTestquestion:remove")
	@Log(title = "试题管理", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tTestquestionService.deleteTTestquestionByIds(ids));
	}
	
}