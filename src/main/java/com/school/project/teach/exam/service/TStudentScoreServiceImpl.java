package com.school.project.teach.exam.service;

import java.util.List;

import com.school.common.support.Convert;
import com.school.project.teach.exam.domain.TStudentScore;
import com.school.project.teach.exam.mapper.TStudentScoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 学生考试得分 服务层实现
 * 
 * @author ruoyi
 * @date 2019-04-11
 */
@Service
public class TStudentScoreServiceImpl implements ITStudentScoreService 
{
	@Autowired
	private TStudentScoreMapper tStudentScoreMapper;

	/**
     * 查询学生考试得分信息
     * 
     * @param id 学生考试得分ID
     * @return 学生考试得分信息
     */
    @Override
	public TStudentScore selectTStudentScoreById(Integer id)
	{
	    return tStudentScoreMapper.selectTStudentScoreById(id);
	}
	
	/**
     * 查询学生考试得分列表
     * 
     * @param tStudentScore 学生考试得分信息
     * @return 学生考试得分集合
     */
	@Override
	public List<TStudentScore> selectTStudentScoreList(TStudentScore tStudentScore)
	{
	    return tStudentScoreMapper.selectTStudentScoreList(tStudentScore);
	}
	
    /**
     * 新增学生考试得分
     * 
     * @param tStudentScore 学生考试得分信息
     * @return 结果
     */
	@Override
	public int insertTStudentScore(TStudentScore tStudentScore)
	{
	    return tStudentScoreMapper.insertTStudentScore(tStudentScore);
	}
	
	/**
     * 修改学生考试得分
     * 
     * @param tStudentScore 学生考试得分信息
     * @return 结果
     */
	@Override
	public int updateTStudentScore(TStudentScore tStudentScore)
	{
	    return tStudentScoreMapper.updateTStudentScore(tStudentScore);
	}

	/**
     * 删除学生考试得分对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTStudentScoreByIds(String ids)
	{
		return tStudentScoreMapper.deleteTStudentScoreByIds(Convert.toStrArray(ids));
	}
	
}
