package com.school.project.teach.course.service;

import java.util.Date;
import java.util.List;

import com.school.common.support.Convert;
import com.school.common.utils.security.ShiroUtils;
import com.school.project.teach.course.domain.TChapter;
import com.school.project.teach.course.mapper.TChapterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 教学中心: 小节管理 服务层实现
 * 
 * @author ruoyi
 * @date 2019-02-21
 */
@Service
public class TChapterServiceImpl implements ITChapterService 
{
	@Autowired
	private TChapterMapper tChapterMapper;

	/**
     * 查询教学中心: 小节管理信息
     * 
     * @param chapterId 教学中心: 小节管理ID
     * @return 教学中心: 小节管理信息
     */
    @Override
	public TChapter selectTChapterById(Integer chapterId)
	{
	    return tChapterMapper.selectTChapterById(chapterId);
	}
	
	/**
     * 查询教学中心: 小节管理列表
     * 
     * @param tChapter 教学中心: 小节管理信息
     * @return 教学中心: 小节管理集合
     */
	@Override
	public List<TChapter> selectTChapterList(TChapter tChapter)
	{
	    return tChapterMapper.selectTChapterList(tChapter);
	}
	
    /**
     * 新增教学中心: 小节管理
     * 
     * @param tChapter 教学中心: 小节管理信息
     * @return 结果
     */
	@Override
	public int insertTChapter(TChapter tChapter)
	{
		tChapter.setCreateBy(ShiroUtils.getLoginName());
		tChapter.setUpdateBy(ShiroUtils.getLoginName());
		tChapter.setCreateTime(new Date());
	    return tChapterMapper.insertTChapter(tChapter);
	}
	
	/**
     * 修改教学中心: 小节管理
     * 
     * @param tChapter 教学中心: 小节管理信息
     * @return 结果
     */
	@Override
	public int updateTChapter(TChapter tChapter)
	{
	    return tChapterMapper.updateTChapter(tChapter);
	}

	/**
     * 删除教学中心: 小节管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTChapterByIds(String ids)
	{
		return tChapterMapper.deleteTChapterByIds(Convert.toStrArray(ids));
	}
	
}
