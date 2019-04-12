package com.school.project.teach.exam.service;


import com.school.project.teach.exam.domain.TStudentScore;

import java.util.List;

/**
 * 学生考试得分 服务层
 * 
 * @author ruoyi
 * @date 2019-04-11
 */
public interface ITStudentScoreService 
{
	/**
     * 查询学生考试得分信息
     * 
     * @param id 学生考试得分ID
     * @return 学生考试得分信息
     */
	public TStudentScore selectTStudentScoreById(Integer id);
	
	/**
     * 查询学生考试得分列表
     * 
     * @param tStudentScore 学生考试得分信息
     * @return 学生考试得分集合
     */
	public List<TStudentScore> selectTStudentScoreList(TStudentScore tStudentScore);
	
	/**
     * 新增学生考试得分
     * 
     * @param tStudentScore 学生考试得分信息
     * @return 结果
     */
	public int insertTStudentScore(TStudentScore tStudentScore);
	
	/**
     * 修改学生考试得分
     * 
     * @param tStudentScore 学生考试得分信息
     * @return 结果
     */
	public int updateTStudentScore(TStudentScore tStudentScore);
		
	/**
     * 删除学生考试得分信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTStudentScoreByIds(String ids);
	
}
