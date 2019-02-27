package com.school.project.teach.answer.service;

import com.school.common.support.Convert;
import com.school.project.teach.answer.domain.TAnswer;
import com.school.project.teach.answer.mapper.TAnswerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 试题答案 服务层实现
 * 
 * @author ruoyi
 * @date 2019-02-27
 */
@Service
public class TAnswerServiceImpl implements ITAnswerService 
{
	@Autowired
	private TAnswerMapper tAnswerMapper;

	/**
     * 查询试题答案信息
     * 
     * @param sId 试题答案ID
     * @return 试题答案信息
     */
    @Override
	public TAnswer selectTAnswerById(Integer sId)
	{
	    return tAnswerMapper.selectTAnswerById(sId);
	}
	
	/**
     * 查询试题答案列表
     * 
     * @param tAnswer 试题答案信息
     * @return 试题答案集合
     */
	@Override
	public List<TAnswer> selectTAnswerList(TAnswer tAnswer)
	{
	    return tAnswerMapper.selectTAnswerList(tAnswer);
	}
	
    /**
     * 新增试题答案
     * 
     * @param tAnswer 试题答案信息
     * @return 结果
     */
	@Override
	public int insertTAnswer(TAnswer tAnswer)
	{
	    return tAnswerMapper.insertTAnswer(tAnswer);
	}
	
	/**
     * 修改试题答案
     * 
     * @param tAnswer 试题答案信息
     * @return 结果
     */
	@Override
	public int updateTAnswer(TAnswer tAnswer)
	{
	    return tAnswerMapper.updateTAnswer(tAnswer);
	}

	/**
     * 删除试题答案对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTAnswerByIds(String ids)
	{
		return tAnswerMapper.deleteTAnswerByIds(Convert.toStrArray(ids));
	}
	
}
