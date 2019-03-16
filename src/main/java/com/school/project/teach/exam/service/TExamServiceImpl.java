package com.school.project.teach.exam.service;

import com.school.common.support.Convert;
import com.school.project.teach.exam.domain.TExam;
import com.school.project.teach.exam.mapper.TExamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 试卷管理 服务层实现
 * 
 * @author ruoyi
 * @date 2019-03-10
 */
@Service
public class TExamServiceImpl implements ITExamService 
{
	@Autowired
	private TExamMapper tExamMapper;

	/**
     * 查询试卷管理信息
     * 
     * @param eId 试卷管理ID
     * @return 试卷管理信息
     */
    @Override
	public TExam selectTExamById(Integer eId)
	{
	    return tExamMapper.selectTExamById(eId);
	}
	
	/**
     * 查询试卷管理列表
     * 
     * @param tExam 试卷管理信息
     * @return 试卷管理集合
     */
	@Override
	public List<TExam> selectTExamList(TExam tExam)
	{
	    return tExamMapper.selectTExamList(tExam);
	}
	
    /**
     * 新增试卷管理
     * 
     * @param tExam 试卷管理信息
     * @return 结果
     */
	@Override
	public int insertTExam(TExam tExam)
	{
	    return tExamMapper.insertTExam(tExam);
	}
	
	/**
     * 修改试卷管理
     * 
     * @param tExam 试卷管理信息
     * @return 结果
     */
	@Override
	public int updateTExam(TExam tExam)
	{
	    return tExamMapper.updateTExam(tExam);
	}

	/**
     * 删除试卷管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTExamByIds(String ids)
	{
		return tExamMapper.deleteTExamByIds(Convert.toStrArray(ids));
	}
	
}
