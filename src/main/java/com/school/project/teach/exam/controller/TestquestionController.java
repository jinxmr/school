package com.school.project.teach.exam.controller;

import java.util.List;

import com.school.common.utils.UUIDUtil;
import com.school.common.utils.poi.ExcelUtil;
import com.school.framework.aspectj.lang.annotation.Log;
import com.school.framework.aspectj.lang.enums.BusinessType;
import com.school.framework.web.controller.BaseController;
import com.school.framework.web.domain.AjaxResult;
import com.school.framework.web.page.TableDataInfo;
import com.school.project.teach.answer.domain.TAnswer;
import com.school.project.teach.answer.service.ITAnswerService;
import com.school.project.teach.answer.service.TAnswerServiceImpl;
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

	@Autowired
	private ITAnswerService tAnswerService;
	
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
	public AjaxResult addSave(Testquestion tTestquestion, TAnswer tAnswer)
	{
		tTestquestion.setQId(UUIDUtil.getUUID());
		String answerstr = tAnswer.getSName();
		int res = 0;
		//判断如果获取到的不为空
		if(null != answerstr && "" != answerstr) {
			//根据,分割
			String[] answers = answerstr.split(",");
			for(int i=0;i<answers.length;i++) {
				//组装答案对象
				TAnswer newAnswer = new TAnswer();
				newAnswer.setQId(tTestquestion.getQId());
				newAnswer.setSName(answers[i]);
				newAnswer.setSSort(i);
				//如果前台传过来的值与i相匹配 则说明是正确答案
				if(tAnswer.getIsRight()==i){
					newAnswer.setIsRight(tAnswer.getIsRight());
				} else {
					newAnswer.setIsRight(-1);
				}
				int ares = tAnswerService.insertTAnswer(newAnswer);
				res += ares;
			}
			if(res == answers.length) {
				int ok = tTestquestionService.insertTTestquestion(tTestquestion);
				return toAjax(ok);
			}
		}
		return toAjax(0);
	}

	/**
	 * 修改试题管理
	 */
	@GetMapping("/edit/{qId}")
	public String edit(@PathVariable("qId") String qId, ModelMap mmap)
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
	public AjaxResult editSave(Testquestion tTestquestion , TAnswer tAnswer)
	{
		//判断如果获取到的不为空
		String answerstr = tAnswer.getSName();
		int res = 0;
		if(null != answerstr && "" != answerstr) {
			//先删除后新增
			tAnswerService.deleteAnswerByQId(tTestquestion.getQId());
			String[] answers = answerstr.split(",");
			for(int i=0;i<answers.length;i++) {
				//组装答案对象
				TAnswer newAnswer = new TAnswer();
				newAnswer.setQId(tTestquestion.getQId());
				newAnswer.setSName(answers[i]);
				newAnswer.setSSort(i);
				//如果前台传过来的值与i相匹配 则说明是正确答案
				if(tAnswer.getIsRight()==i){
					newAnswer.setIsRight(tAnswer.getIsRight());
				} else {
					newAnswer.setIsRight(-1);
				}
				int ares = tAnswerService.insertTAnswer(newAnswer);
				res += ares;
			}
			if(res == answers.length) {
				int ok = tTestquestionService.updateTTestquestion(tTestquestion);
				return toAjax(ok);
			}
		}
		return toAjax(0);
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



	@GetMapping("/qlist/{eId}")
	@ResponseBody
	public List<Testquestion> selectByEID(@PathVariable("eId")String eId) {
		List<Testquestion> testquestionList = tTestquestionService.selectTTestquestionListByEid(eId);
		return testquestionList;
	}

}
