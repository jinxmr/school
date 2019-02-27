package com.school.project.teach.answer.mapper;


import com.school.project.teach.answer.domain.TAnswer;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 试题答案 数据层
 * 
 * @author ruoyi
 * @date 2019-02-27
 */
@Repository
public interface TAnswerMapper 
{
	/**
     * 查询试题答案信息
     * 
     * @param sId 试题答案ID
     * @return 试题答案信息
     */
	public TAnswer selectTAnswerById(Integer sId);
	
	/**
     * 查询试题答案列表
     * 
     * @param tAnswer 试题答案信息
     * @return 试题答案集合
     */
	public List<TAnswer> selectTAnswerList(TAnswer tAnswer);
	
	/**
     * 新增试题答案
     * 
     * @param tAnswer 试题答案信息
     * @return 结果
     */
	public int insertTAnswer(TAnswer tAnswer);
	
	/**
     * 修改试题答案
     * 
     * @param tAnswer 试题答案信息
     * @return 结果
     */
	public int updateTAnswer(TAnswer tAnswer);
	
	/**
     * 删除试题答案
     * 
     * @param sId 试题答案ID
     * @return 结果
     */
	public int deleteTAnswerById(Integer sId);
	
	/**
     * 批量删除试题答案
     * 
     * @param sIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteTAnswerByIds(String[] sIds);

	/**
	 * 根据试题ID插叙答案List
	 */
	public TAnswer selectById(String qId);
	
}