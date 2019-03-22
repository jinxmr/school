package com.school.project.teach.exam.mapper;


import com.school.project.teach.exam.domain.Testquestion;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 试题管理 数据层
 * 
 * @author ruoyi
 * @date 2019-02-23
 */
@Repository
public interface TestquestionMapper
{
	/**
     * 查询试题管理信息
     * 
     * @param qId 试题管理ID
     * @return 试题管理信息
     */
	public Testquestion selectTTestquestionById(String qId);
	
	/**
     * 查询试题管理列表
     * 
     * @param tTestquestion 试题管理信息
     * @return 试题管理集合
     */
	public List<Testquestion> selectTTestquestionList(Testquestion tTestquestion);

	/**
	 * 根据试题类型查询
	 * @param qType
	 * @return
	 */
	public List<Testquestion> selectTTestquestionListByQType(Integer qType);
	
	/**
     * 新增试题管理
     * 
     * @param tTestquestion 试题管理信息
     * @return 结果
     */
	public int insertTestquestion(Testquestion tTestquestion);
	
	/**
     * 修改试题管理
     * 
     * @param tTestquestion 试题管理信息
     * @return 结果
     */
	public int updateTTestquestion(Testquestion tTestquestion);
	
	/**
     * 删除试题管理
     * 
     * @param qId 试题管理ID
     * @return 结果
     */
	public int deleteTTestquestionById(String qId);
	
	/**
     * 批量删除试题管理
     * 
     * @param qIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteTTestquestionByIds(String[] qIds);
	
}