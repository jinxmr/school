package com.school.project.teach.exam.service;

import java.util.ArrayList;
import java.util.List;

import com.school.common.support.Convert;
import com.school.project.teach.exam.domain.TExamQuestion;
import com.school.project.teach.exam.domain.Testquestion;
import com.school.project.teach.exam.mapper.TExamQuestionMapper;
import com.school.project.teach.exam.mapper.TestquestionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 试题管理 服务层实现
 * 
 * @author ruoyi
 * @date 2019-02-23
 */
@Service
public class TestquestionServiceImpl implements TestquestionService
{
	private static final Logger log = LoggerFactory.getLogger(TestquestionServiceImpl.class);
	@Autowired
	private TestquestionMapper tTestquestionMapper;

	@Autowired
	private TExamQuestionMapper tExamQuestionMapper;

	/**
     * 查询试题管理信息
     * 
     * @param qId 试题管理ID
     * @return 试题管理信息
     */
    @Override
	public Testquestion selectTTestquestionById(String qId)
	{
	    return tTestquestionMapper.selectTTestquestionById(qId);
	}
	
	/**
     * 查询试题管理列表
     * 
     * @param tTestquestion 试题管理信息
     * @return 试题管理集合
     */
	@Override
	public List<Testquestion> selectTTestquestionList(Testquestion tTestquestion)
	{
	    return tTestquestionMapper.selectTTestquestionList(tTestquestion);
	}
	
    /**
     * 新增试题管理
     * 
     * @param tTestquestion 试题管理信息
     * @return 结果
     */
	@Override
	public int insertTTestquestion(Testquestion tTestquestion)
	{
	    return tTestquestionMapper.insertTestquestion(tTestquestion);
	}
	
	/**
     * 修改试题管理
     * 
     * @param tTestquestion 试题管理信息
     * @return 结果
     */
	@Override
	public int updateTTestquestion(Testquestion tTestquestion)
	{
	    return tTestquestionMapper.updateTTestquestion(tTestquestion);
	}

	/**
     * 删除试题管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTTestquestionByIds(String ids)
	{
		return tTestquestionMapper.deleteTTestquestionByIds(Convert.toStrArray(ids));
	}

	@Override
	public List<Testquestion> selectTTestquestionListByEid(String eId) {
		TExamQuestion tExamQuestion = new TExamQuestion();
		tExamQuestion.setEId(eId);
		//根据试卷ID查询试题List
		List<Testquestion> tExamQuestionList = tTestquestionMapper.selectQuestionByEId(eId);
		/*List<String> qIdList = new ArrayList<>();
		//将qId抽取出来 放入List
		if(tExamQuestionList.size()>0) {
			for (TExamQuestion teq:tExamQuestionList) {
				qIdList.add(teq.getQId());
			}
			log.info("========================="+qIdList.toString());
		}
		//根据qIdList查询试题List集合
		tTestquestionMapper.sele*/
		return tExamQuestionList;
	}
}
