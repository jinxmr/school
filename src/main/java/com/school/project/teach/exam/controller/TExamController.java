package com.school.project.teach.exam.controller;

import java.util.*;

import com.school.common.utils.poi.ExcelUtil;
import com.school.framework.aspectj.lang.annotation.Log;
import com.school.framework.aspectj.lang.enums.BusinessType;
import com.school.framework.web.controller.BaseController;
import com.school.framework.web.domain.AjaxResult;
import com.school.framework.web.page.TableDataInfo;
import com.school.project.system.user.domain.User;
import com.school.project.teach.answer.domain.TAnswer;
import com.school.project.teach.answer.service.ITAnswerService;
import com.school.project.teach.exam.domain.TExam;
import com.school.project.teach.exam.domain.TStudentScore;
import com.school.project.teach.exam.service.ITExamService;
import com.school.project.teach.exam.service.ITStudentScoreService;
import com.school.project.teach.exam.service.TestquestionService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


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

	@Autowired
	private TestquestionService testquestionService;

	@Autowired
	private ITAnswerService itAnswerService;

	@Autowired
	private ITStudentScoreService tStudentScoreService;
	
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

	/**
	 * 跳转考试试题页面
	 * @param eId
	 * @param mmap
	 * @return
	 */
	@GetMapping("/toExam/{eId}")
	public String toExam(@PathVariable("eId") String eId, ModelMap mmap) {
		mmap.put("eid",eId);
		return "web/questionList";
	}

	@PostMapping(value = "/sumScore")
	@ResponseBody
	public AjaxResult sumScore(@RequestBody Map<String,String> map, HttpServletRequest request){
		String examId = map.get("examId");
		map.remove("examId");
		List<Integer> keyIDs = getKeyID(map);
		//查询试题答案 获取试题的正确答案
		List<TAnswer> tAnswers = itAnswerService.selectByQIds(keyIDs);
		//存放答案正确的qId List
		List<String> qIdList = new ArrayList<>();
		//根据试题ID取map中的value值与查询出来的答案做比较
		for(int i=0;i<tAnswers.size();i++) {
			String qId = tAnswers.get(i).getQId();//试题ID
			Integer sId = tAnswers.get(i).getSId();//答案ID
			Integer mapsId = Integer.valueOf(map.get(qId));//根据qId获取map中的答案ID
			if(sId == mapsId) {
				qIdList.add(qId);
				continue;
			}
		}
		//获取登陆用户
		User user = (User) request.getSession().getAttribute("user");
		//根据正确答案的qId查询试题List
		Integer sumScore = testquestionService.selectSumByqIds(qIdList);
		//构建学生考试得分对象
		TStudentScore studentScore = new TStudentScore();
		studentScore.setSumScore(sumScore);//得分
		studentScore.setExamTime(new Date());
		if(examId == null) {
			return toAjax(0);
		}
		studentScore.setExamId(examId);
		if(null != user) {
			studentScore.setExamUserid(Math.toIntExact(user.getUserId()));
			studentScore.setExamUsername(user.getUserName());
		}
		int res = tStudentScoreService.insertTStudentScore(studentScore);
		return AjaxResult.success("考试完成，您的得分是："+sumScore+" 分。");
	}

	private static List<Integer> getKeyID(Map<String,String> map) {
		List<Integer> list = new ArrayList<>();
		//取Key值
		Set<String> set = 	map.keySet();
		for(String key: set) {
			list.add(Integer.valueOf(key));
		}
		return list;
	}
}
