package com.school.project.teach.answer.controller;

import java.util.List;

import com.school.common.utils.poi.ExcelUtil;
import com.school.framework.aspectj.lang.annotation.Log;
import com.school.framework.aspectj.lang.enums.BusinessType;
import com.school.framework.web.controller.BaseController;
import com.school.framework.web.domain.AjaxResult;
import com.school.framework.web.page.TableDataInfo;
import com.school.project.teach.answer.domain.TAnswer;
import com.school.project.teach.answer.service.ITAnswerService;
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
 * 试题答案 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-02-27
 */
@Controller
@RequestMapping("/exam/tAnswer")
public class TAnswerController extends BaseController
{
    private String prefix = "teach/answer";
	
	@Autowired
	private ITAnswerService tAnswerService;
	
	@RequiresPermissions("exam:tAnswer:view")
	@GetMapping()
	public String tAnswer()
	{
	    return prefix + "/tAnswer";
	}
	
	/**
	 * 查询试题答案列表
	 */
	@RequiresPermissions("exam:tAnswer:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TAnswer tAnswer)
	{
		startPage();
        List<TAnswer> list = tAnswerService.selectTAnswerList(tAnswer);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出试题答案列表
	 */
	@RequiresPermissions("exam:tAnswer:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TAnswer tAnswer)
    {
    	List<TAnswer> list = tAnswerService.selectTAnswerList(tAnswer);
        ExcelUtil<TAnswer> util = new ExcelUtil<TAnswer>(TAnswer.class);
        return util.exportExcel(list, "tAnswer");
    }
	
	/**
	 * 新增试题答案
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存试题答案
	 */
	@RequiresPermissions("exam:tAnswer:add")
	@Log(title = "试题答案", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TAnswer tAnswer)
	{		
		return toAjax(tAnswerService.insertTAnswer(tAnswer));
	}

	/**
	 * 修改试题答案
	 */
	@GetMapping("/edit/{sId}")
	public String edit(@PathVariable("sId") Integer sId, ModelMap mmap)
	{
		TAnswer tAnswer = tAnswerService.selectTAnswerById(sId);
		mmap.put("tAnswer", tAnswer);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存试题答案
	 */
	@RequiresPermissions("exam:tAnswer:edit")
	@Log(title = "试题答案", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TAnswer tAnswer)
	{		
		return toAjax(tAnswerService.updateTAnswer(tAnswer));
	}
	
	/**
	 * 删除试题答案
	 */
	@RequiresPermissions("exam:tAnswer:remove")
	@Log(title = "试题答案", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tAnswerService.deleteTAnswerByIds(ids));
	}
	
}
