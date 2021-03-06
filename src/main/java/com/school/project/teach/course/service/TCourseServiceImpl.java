package com.school.project.teach.course.service;

import java.util.Date;
import java.util.List;

import com.school.common.support.Convert;
import com.school.common.utils.security.ShiroUtils;
import com.school.project.system.base.mapper.BaseMapper;
import com.school.project.system.base.service.BaseServiceImpl;
import com.school.project.teach.course.domain.TCourse;
import com.school.project.teach.course.mapper.TCourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 教学中心: 课程管理 服务层实现
 *
 * @author ruoyi
 * @date 2019-02-19
 */
@Service
public class TCourseServiceImpl extends BaseServiceImpl<TCourse> implements ITCourseService
{

	@Autowired
	private TCourseMapper tCourseMapper;

	@Override
	protected BaseMapper<TCourse> getBaseMapper() {
		return tCourseMapper;
	}
	/**
     * 查询教学中心: 课程管理信息
     *
     * @param courseId 教学中心: 课程管理ID
     * @return 教学中心: 课程管理信息
     */
    @Override
	public TCourse selectTCourseById(Integer courseId)
	{
	    return tCourseMapper.selectTCourseById(courseId);
	}

	/**
     * 查询教学中心: 课程管理列表
     *
     * @param tCourse 教学中心: 课程管理信息
     * @return 教学中心: 课程管理集合
     */
	@Override
	public List<TCourse> selectTCourseList(TCourse tCourse)
	{
	    return tCourseMapper.selectTCourseList(tCourse);
	}

    /**
     * 新增教学中心: 课程管理
     *
     * @param tCourse 教学中心: 课程管理信息
     * @return 结果
     */
	@Override
	public int insertTCourse(TCourse tCourse)
	{
		tCourse.setUserId(Math.toIntExact(ShiroUtils.getUserId()));
		tCourse.setCreateBy(ShiroUtils.getLoginName());
		tCourse.setUpdateBy(ShiroUtils.getLoginName());
		tCourse.setCreateTime(new Date());
	    return tCourseMapper.insertTCourse(tCourse);
	}

	/**
     * 修改教学中心: 课程管理
     *
     * @param tCourse 教学中心: 课程管理信息
     * @return 结果
     */
	@Override
	public int updateTCourse(TCourse tCourse)
	{
		tCourse.setUpdateBy(ShiroUtils.getLoginName());
	    return tCourseMapper.updateTCourse(tCourse);
	}

	/**
     * 删除教学中心: 课程管理对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTCourseByIds(String ids)
	{
		return tCourseMapper.deleteTCourseByIds(Convert.toStrArray(ids));
	}

}
