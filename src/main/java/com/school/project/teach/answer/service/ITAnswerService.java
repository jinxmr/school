package com.school.project.teach.answer.service;


import com.school.project.teach.answer.domain.TAnswer;

import java.util.List;

/**
 * 试题答案 服务层
 * 
 * @author ruoyi
 * @date 2019-02-27
 */
public interface ITAnswerService 
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
     * 删除试题答案信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTAnswerByIds(String ids);

	/**
	 * 根据试题ID删除答案
	 */
	public int deleteAnswerByQId(String qId);

	/**
	 * 查询答案列表
	 */
	public List<TAnswer> selectByQIds(List<Integer> qIds);
}
