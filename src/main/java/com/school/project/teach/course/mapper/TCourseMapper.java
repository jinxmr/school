package com.school.project.teach.course.mapper;

import com.school.project.teach.course.domain.TCourse;

import java.util.List;

/**
 * 教学中心: 课程管理 数据层
 * 
 * @author ruoyi
 * @date 2019-02-19
 */
public interface TCourseMapper 
{
	/**
     * 查询教学中心: 课程管理信息
     * 
     * @param courseId 教学中心: 课程管理ID
     * @return 教学中心: 课程管理信息
     */
	public TCourse selectTCourseById(Integer courseId);
	
	/**
     * 查询教学中心: 课程管理列表
     * 
     * @param tCourse 教学中心: 课程管理信息
     * @return 教学中心: 课程管理集合
     */
	public List<TCourse> selectTCourseList(TCourse tCourse);
	
	/**
     * 新增教学中心: 课程管理
     * 
     * @param tCourse 教学中心: 课程管理信息
     * @return 结果
     */
	public int insertTCourse(TCourse tCourse);
	
	/**
     * 修改教学中心: 课程管理
     * 
     * @param tCourse 教学中心: 课程管理信息
     * @return 结果
     */
	public int updateTCourse(TCourse tCourse);
	
	/**
     * 删除教学中心: 课程管理
     * 
     * @param courseId 教学中心: 课程管理ID
     * @return 结果
     */
	public int deleteTCourseById(Integer courseId);
	
	/**
     * 批量删除教学中心: 课程管理
     * 
     * @param courseIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteTCourseByIds(String[] courseIds);
	
}