package com.school.project.teach.exam.controller;

import java.util.List;

import com.school.common.utils.poi.ExcelUtil;
import com.school.framework.aspectj.lang.annotation.Log;
import com.school.framework.aspectj.lang.enums.BusinessType;
import com.school.framework.web.controller.BaseController;
import com.school.framework.web.domain.AjaxResult;
import com.school.framework.web.page.TableDataInfo;
import com.school.project.teach.exam.domain.TStudentScore;
import com.school.project.teach.exam.service.ITStudentScoreService;
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
 * 学生考试得分 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-04-11
 */
@Controller
@RequestMapping("/exam/tStudentScore")
public class TStudentScoreController extends BaseController
{
    private String prefix = "teach/tStudentScore";
	
	@Autowired
	private ITStudentScoreService tStudentScoreService;
	
	@RequiresPermissions("exam:tStudentScore:view")
	@GetMapping()
	public String tStudentScore()
	{
	    return prefix + "/tStudentScore";
	}
	
	/**
	 * 查询学生考试得分列表
	 */
	@RequiresPermissions("exam:tStudentScore:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TStudentScore tStudentScore)
	{
		startPage();
        List<TStudentScore> list = tStudentScoreService.selectTStudentScoreList(tStudentScore);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出学生考试得分列表
	 */
	@RequiresPermissions("exam:tStudentScore:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TStudentScore tStudentScore)
    {
    	List<TStudentScore> list = tStudentScoreService.selectTStudentScoreList(tStudentScore);
        ExcelUtil<TStudentScore> util = new ExcelUtil<TStudentScore>(TStudentScore.class);
        return util.exportExcel(list, "tStudentScore");
    }
	
	/**
	 * 新增学生考试得分
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存学生考试得分
	 */
	@RequiresPermissions("exam:tStudentScore:add")
	@Log(title = "学生考试得分", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TStudentScore tStudentScore)
	{		
		return toAjax(tStudentScoreService.insertTStudentScore(tStudentScore));
	}

	/**
	 * 修改学生考试得分
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		TStudentScore tStudentScore = tStudentScoreService.selectTStudentScoreById(id);
		mmap.put("tStudentScore", tStudentScore);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存学生考试得分
	 */
	@RequiresPermissions("exam:tStudentScore:edit")
	@Log(title = "学生考试得分", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TStudentScore tStudentScore)
	{		
		return toAjax(tStudentScoreService.updateTStudentScore(tStudentScore));
	}
	
	/**
	 * 删除学生考试得分
	 */
	@RequiresPermissions("exam:tStudentScore:remove")
	@Log(title = "学生考试得分", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tStudentScoreService.deleteTStudentScoreByIds(ids));
	}
	
}
