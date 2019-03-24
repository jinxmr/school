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

    @GetMapping("/chapterIndex/{courseId}")
    public String webChapterIndex(@PathVariable("courseId") int courseId,ModelMap mmap)  {
        mmap.put("courseId", courseId);
        return "web/chapterList";
    }

    @PostMapping("/chapterList/{courseId}")
    @ResponseBody
    public TableDataInfo chapterList(@PathVariable("courseId") int courseId,TChapter tChapter) {

        //根据课程ID查询小节
        tChapter.setCourseId(courseId);
        tChapter.setStatus("0");
        List<TChapter> tChapterList = chapterService.selectTChapterList(tChapter);
        return getDataTable(tChapterList);
    }
}