package com.school.project.teach.course.service;


import com.school.project.teach.course.domain.TChapter;

import java.util.List;

/**
 * 教学中心: 小节管理 服务层
 * 
 * @author ruoyi
 * @date 2019-02-21
 */
public interface ITChapterService 
{
	/**
     * 查询教学中心: 小节管理信息
     * 
     * @param chapterId 教学中心: 小节管理ID
     * @return 教学中心: 小节管理信息
     */
	public TChapter selectTChapterById(Integer chapterId);
	
	/**
     * 查询教学中心: 小节管理列表
     * 
     * @param tChapter 教学中心: 小节管理信息
     * @return 教学中心: 小节管理集合
     */
	public List<TChapter> selectTChapterList(TChapter tChapter);
	
	/**
     * 新增教学中心: 小节管理
     * 
     * @param tChapter 教学中心: 小节管理信息
     * @return 结果
     */
	public int insertTChapter(TChapter tChapter);
	
	/**
     * 修改教学中心: 小节管理
     * 
     * @param tChapter 教学中心: 小节管理信息
     * @return 结果
     */
	public int updateTChapter(TChapter tChapter);
		
	/**
     * 删除教学中心: 小节管理信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTChapterByIds(String ids);
	
}
