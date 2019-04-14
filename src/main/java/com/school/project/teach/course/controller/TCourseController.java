package com.school.project.teach.course.controller;

import java.util.List;

import com.school.common.utils.poi.ExcelUtil;
import com.school.framework.aspectj.lang.annotation.Log;
import com.school.framework.aspectj.lang.enums.BusinessType;
import com.school.framework.web.controller.BaseController;
import com.school.framework.web.domain.AjaxResult;
import com.school.framework.web.page.TableDataInfo;
import com.school.project.teach.course.domain.TCourse;
import com.school.project.teach.course.service.ITCourseService;
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
 * 教学中心: 课程管理 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-02-19
 */
@Controller
@RequestMapping("/teach/tCourse")
public class TCourseController extends BaseController
{
    private String prefix = "teach/course";
	
	@Autowired
	private ITCourseService tCourseService;
	
	@RequiresPermissions("teach:tCourse:view")
	@GetMapping()
	public String tCourse()
	{
	    return prefix + "/course";
	}
	
	/**
	 * 查询教学中心: 课程管理列表
	 */
	//@RequiresPermissions("teach:tCourse:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TCourse tCourse)
	{
		startPage();
        List<TCourse> list = tCourseService.selectTCourseList(tCourse);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出教学中心: 课程管理列表
	 */
	@RequiresPermissions("teach:tCourse:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TCourse tCourse)
    {
    	List<TCourse> list = tCourseService.selectTCourseList(tCourse);
        ExcelUtil<TCourse> util = new ExcelUtil<TCourse>(TCourse.class);
        return util.exportExcel(list, "tCourse");
    }
	
	/**
	 * 新增教学中心: 课程管理
	 */
	@GetMapping("/add")
	public String add()
	{

	    return prefix + "/add";
	}
	
	/**
	 * 新增保存教学中心: 课程管理
	 */
	@RequiresPermissions("teach:tCourse:add")
	@Log(title = "教学中心: 课程管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TCourse tCourse)
	{
		return toAjax(tCourseService.insertTCourse(tCourse));
	}

	/**
	 * 修改教学中心: 课程管理
	 */
	@GetMapping("/edit/{courseId}")
	public String edit(@PathVariable("courseId") Integer courseId, ModelMap mmap)
	{
		TCourse tCourse = tCourseService.selectTCourseById(courseId);
		mmap.put("tCourse", tCourse);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存教学中心: 课程管理
	 */
	@RequiresPermissions("teach:tCourse:edit")
	@Log(title = "教学中心: 课程管理", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TCourse tCourse)
	{		
		return toAjax(tCourseService.updateTCourse(tCourse));
	}
	
	/**
	 * 删除教学中心: 课程管理
	 */
	@RequiresPermissions("teach:tCourse:remove")
	@Log(title = "教学中心: 课程管理", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tCourseService.deleteTCourseByIds(ids));
	}

	/**
	 * 查询小节列表-详细
	 */
	@RequiresPermissions("system:dict:list")
	@GetMapping("/detail/{curseId}")
	public String detail(@PathVariable("curseId") Long courseId, ModelMap mmap)
	{
		TCourse tCourse = tCourseService.selectTCourseById(Math.toIntExact(courseId));
		mmap.put("course", tCourse);
		List<TCourse> tCourses = tCourseService.selectAll();
		mmap.put("courseList", tCourses);
		return "teach/chapter/tChapter";
	}
	
}
