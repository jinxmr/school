package com.school.project.web;

import com.school.framework.web.controller.BaseController;
import com.school.framework.web.page.TableDataInfo;
import com.school.project.teach.course.domain.TChapter;
import com.school.project.teach.course.service.ITChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2019/3/24.
 */
@Controller
@RequestMapping("/web")
public class WebController extends BaseController {

    @Autowired
    private ITChapterService chapterService;

    /**
     * 跳转
     * @param courseId
     * @param mmap
     * @return
     */
    @GetMapping("/chapterIndex/{courseId}")
    public String webChapterIndex(@PathVariable("courseId") int courseId,ModelMap mmap)  {
        mmap.put("courseId", courseId);
        return "web/chapterList";
    }

    /**
     * 根据课程ID查询课件List
     * @param courseId
     * @param tChapter
     * @return
     */
    @PostMapping("/chapterList/{courseId}")
    @ResponseBody
    public TableDataInfo chapterList(@PathVariable("courseId") int courseId,TChapter tChapter) {

        //根据课程ID查询小节
        tChapter.setCourseId(courseId);
        tChapter.setStatus("0");
        List<TChapter> tChapterList = chapterService.selectTChapterList(tChapter);
        return getDataTable(tChapterList);
    }

    /**
     * 跳转到试卷列表
     * @param map
     * @return
     */
    @RequestMapping("/toExamList")
    public String toWebExamList(ModelMap map) {

        return "web/examList";
    }
}