package com.school.project.teach.exam.service;

import java.util.List;

import com.school.common.support.Convert;
import com.school.project.teach.exam.domain.Testquestion;
import com.school.project.teach.exam.mapper.TestquestionMapper;
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
	@Autowired
	private TestquestionMapper tTestquestionMapper;

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
	
}
