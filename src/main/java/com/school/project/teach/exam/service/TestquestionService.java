package com.school.project.teach.exam.service;

import com.school.project.teach.exam.domain.Testquestion;

import java.util.List;

/**
 * 试题管理 服务层
 * 
 * @author ruoyi
 * @date 2019-02-23
 */
public interface TestquestionService
{
	/**
     * 查询试题管理信息
     * 
     * @param qId 试题管理ID
     * @return 试题管理信息
     */
	public Testquestion selectTTestquestionById(Integer qId);
	
	/**
     * 查询试题管理列表
     * 
     * @param tTestquestion 试题管理信息
     * @return 试题管理集合
     */
	public List<Testquestion> selectTTestquestionList(Testquestion tTestquestion);
	
	/**
     * 新增试题管理
     * 
     * @param tTestquestion 试题管理信息
     * @return 结果
     */
	public int insertTTestquestion(Testquestion tTestquestion);
	
	/**
     * 修改试题管理
     * 
     * @param tTestquestion 试题管理信息
     * @return 结果
     */
	public int updateTTestquestion(Testquestion tTestquestion);
		
	/**
     * 删除试题管理信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTTestquestionByIds(String ids);
	
}
