package com.school.project.teach.exam.mapper;


import com.school.project.teach.exam.domain.TExam;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 试卷管理 数据层
 * 
 * @author ruoyi
 * @date 2019-03-10
 */
@Repository
public interface TExamMapper 
{
	/**
     * 查询试卷管理信息
     * 
     * @param eId 试卷管理ID
     * @return 试卷管理信息
     */
	public TExam selectTExamById(String eId);
	
	/**
     * 查询试卷管理列表
     * 
     * @param tExam 试卷管理信息
     * @return 试卷管理集合
     */
	public List<TExam> selectTExamList(TExam tExam);
	
	/**
     * 新增试卷管理
     * 
     * @param tExam 试卷管理信息
     * @return 结果
     */
	public int insertTExam(TExam tExam);
	
	/**
     * 修改试卷管理
     * 
     * @param tExam 试卷管理信息
     * @return 结果
     */
	public int updateTExam(TExam tExam);
	
	/**
     * 删除试卷管理
     * 
     * @param eId 试卷管理ID
     * @return 结果
     */
	public int deleteTExamById(String eId);
	
	/**
     * 批量删除试卷管理
     * 
     * @param eIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteTExamByIds(String[] eIds);
	
}