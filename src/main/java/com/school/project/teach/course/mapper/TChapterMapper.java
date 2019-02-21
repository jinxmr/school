package com.school.project.teach.course.mapper;


import com.school.project.teach.course.domain.TChapter;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 教学中心: 小节管理 数据层
 * 
 * @author ruoyi
 * @date 2019-02-21
 */
@Repository
public interface TChapterMapper 
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
     * 删除教学中心: 小节管理
     * 
     * @param chapterId 教学中心: 小节管理ID
     * @return 结果
     */
	public int deleteTChapterById(Integer chapterId);
	
	/**
     * 批量删除教学中心: 小节管理
     * 
     * @param chapterIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteTChapterByIds(String[] chapterIds);
	
}