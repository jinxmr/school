package com.school.project.teach.course.domain;

import com.school.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.util.Date;

/**
 * 教学中心: 小节管理表 t_chapter
 * 
 * @author ruoyi
 * @date 2019-02-21
 */
public class TChapter extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID */
	private Integer chapterId;
	/** 课程主键ID */
	private Integer courseId;
	/** 小节名称 */
	private String chapterName;
	/** pdf路径 */
	private String pdfUrl;
	/** 视频路径 */
	private String videoUrl;
	/** 小节描述 */
	private String remark;
	/** 课程状态（0正常1停用） */
	private String status;
	/** 创建者 */
	private String createBy;
	/** 创建时间 */
	private Date createTime;
	/** 更新者 */
	private String updateBy;
	/** 修改时间 */
	private Date updateTime;
	/** 文件名称 */
	private String fileName;

	public void setChapterId(Integer chapterId) 
	{
		this.chapterId = chapterId;
	}

	public Integer getChapterId() 
	{
		return chapterId;
	}
	public void setCourseId(Integer courseId)
	{
		this.courseId = courseId;
	}

	public Integer getCourseId()
	{
		return courseId;
	}
	public void setChapterName(String chapterName) 
	{
		this.chapterName = chapterName;
	}

	public String getChapterName() 
	{
		return chapterName;
	}
	public void setPdfUrl(String pdfUrl) 
	{
		this.pdfUrl = pdfUrl;
	}

	public String getPdfUrl() 
	{
		return pdfUrl;
	}
	public void setVideoUrl(String videoUrl) 
	{
		this.videoUrl = videoUrl;
	}

	public String getVideoUrl() 
	{
		return videoUrl;
	}
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
	}
	public void setStatus(String status) 
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}
	public void setCreateBy(String createBy) 
	{
		this.createBy = createBy;
	}

	public String getCreateBy() 
	{
		return createBy;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}
	public void setUpdateBy(String updateBy) 
	{
		this.updateBy = updateBy;
	}

	public String getUpdateBy() 
	{
		return updateBy;
	}
	public void setUpdateTime(Date updateTime) 
	{
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() 
	{
		return updateTime;
	}
	public void setFileName(String fileName) 
	{
		this.fileName = fileName;
	}

	public String getFileName() 
	{
		return fileName;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("chapterId", getChapterId())
            .append("courseId", getCourseId())
            .append("chapterName", getChapterName())
            .append("pdfUrl", getPdfUrl())
            .append("videoUrl", getVideoUrl())
            .append("remark", getRemark())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("fileName", getFileName())
            .toString();
    }
}
