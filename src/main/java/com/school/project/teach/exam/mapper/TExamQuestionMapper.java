package com.school.project.teach.exam.mapper;


import com.school.project.teach.exam.domain.TExamQuestion;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 试卷试题中间 数据层
 * 
 * @author ruoyi
 * @date 2019-03-20
 */
@Repository
public interface TExamQuestionMapper 
{
	/**
     * 查询试卷试题中间信息
     * 
     * @param qId 试卷试题中间ID
     * @return 试卷试题中间信息
     */
	public TExamQuestion selectTExamQuestionById(String qId);
	
	/**
     * 查询试卷试题中间列表
     * 
     * @param tExamQuestion 试卷试题中间信息
     * @return 试卷试题中间集合
     */
	public List<TExamQuestion> selectTExamQuestionList(TExamQuestion tExamQuestion);
	
	/**
     * 新增试卷试题中间
     * 
     * @param tExamQuestion 试卷试题中间信息
     * @return 结果
     */
	public int insertTExamQuestion(TExamQuestion tExamQuestion);
	
	/**
     * 修改试卷试题中间
     * 
     * @param tExamQuestion 试卷试题中间信息
     * @return 结果
     */
	public int updateTExamQuestion(TExamQuestion tExamQuestion);
	
	/**
     * 删除试卷试题中间
     * 
     * @param qId 试卷试题中间ID
     * @return 结果
     */
	public int deleteTExamQuestionById(String qId);
	
	/**
     * 批量删除试卷试题中间
     * 
     * @param qIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteTExamQuestionByIds(String[] qIds);

	/**
	 * 批量插入
	 */
	public int insertList(List<TExamQuestion> list);

	/**
	 * 批量删除试题
	 *
	 * @param eIds 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteTExamQuestionByExamIds(String[] eIds);
	
}