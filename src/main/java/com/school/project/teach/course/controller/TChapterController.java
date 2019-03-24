package com.school.project.teach.course.controller;

import java.util.List;

import com.school.common.utils.poi.ExcelUtil;
import com.school.framework.aspectj.lang.annotation.Log;
import com.school.framework.aspectj.lang.enums.BusinessType;
import com.school.framework.web.controller.BaseController;
import com.school.framework.web.domain.AjaxResult;
import com.school.framework.web.page.TableDataInfo;
import com.school.project.teach.course.domain.TChapter;
import com.school.project.teach.course.domain.TCourse;
import com.school.project.teach.course.service.ITChapterService;
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
 * 教学中心: 小节管理 信息操作处理
 *
 * @author ruoyi
 * @date 2019-02-21
 */
@Controller
@RequestMapping("/system/tChapter")
public class TChapterController extends BaseController {
    private String prefix = "teach/chapter";

    @Autowired
    private ITChapterService tChapterService;

    @Autowired
    private ITCourseService itCourseService;

    @RequiresPermissions("system:tChapter:view")
    @GetMapping()
    public String tChapter() {
        return prefix + "/tChapter";
    }

    /**
     * 查询教学中心: 小节管理列表
     */
    @RequiresPermissions("system:tChapter:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TChapter tChapter) {
        startPage();
        List<TChapter> list = tChapterService.selectTChapterList(tChapter);
        return getDataTable(list);
    }


    /**
     * 导出教学中心: 小节管理列表
     */
    @RequiresPermissions("system:tChapter:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TChapter tChapter) {
        List<TChapter> list = tChapterService.selectTChapterList(tChapter);
        ExcelUtil<TChapter> util = new ExcelUtil<TChapter>(TChapter.class);
        return util.exportExcel(list, "tChapter");
    }

    /**
     * 新增教学中心: 小节管理
     */
    @GetMapping("/add/{courseId}")
    public String add(@PathVariable("courseId") String courseId, ModelMap mmap) {
        mmap.put("courseId", courseId);
        //根据ID查询课程对象
        TCourse tCourse = itCourseService.selectTCourseById(Integer.valueOf(courseId));
        mmap.put("courseName", tCourse.getCourseName());
        return prefix + "/add";
    }

    /**
     * 新增保存教学中心: 小节管理
     */
    @RequiresPermissions("system:tChapter:add")
    @Log(title = "教学中心: 小节管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TChapter tChapter) {
        return toAjax(tChapterService.insertTChapter(tChapter));
    }

    /**
     * 修改教学中心: 小节管理
     */
    @GetMapping("/edit/{chapterId}")
    public String edit(@PathVariable("chapterId") Integer chapterId, ModelMap mmap) {
        TChapter tChapter = tChapterService.selectTChapterById(chapterId);
        mmap.put("tChapter", tChapter);
        return prefix + "/edit";
    }

    /**
     * 修改保存教学中心: 小节管理
     */
    @RequiresPermissions("system:tChapter:edit")
    @Log(title = "教学中心: 小节管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TChapter tChapter) {
        return toAjax(tChapterService.updateTChapter(tChapter));
    }

    /**
     * 删除教学中心: 小节管理
     */
    @RequiresPermissions("system:tChapter:remove")
    @Log(title = "教学中心: 小节管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(tChapterService.deleteTChapterByIds(ids));
    }

}
