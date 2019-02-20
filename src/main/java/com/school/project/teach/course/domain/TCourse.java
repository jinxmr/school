package com.school.project.teach.course.domain;

import com.school.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.util.Date;

/**
 * 教学中心: 课程管理表 t_course
 * 
 * @author ruoyi
 * @date 2019-02-19
 */
public class TCourse extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID */
	private Integer courseId;
	/** 授课老师主键ID */
	private Integer userId;
	/** 课程名称 */
	private String courseName;
	/** 封面图片路径 */
	private String picUrl;
	/** pdf路径 */
	private String pdfUrl;
	/** 视频路径 */
	private String videoUrl;
	/** 课程描述 */
	private String remark;
	/** 课程状态（0正常 1停用） */
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

	public void setCourseId(Integer courseId) 
	{
		this.courseId = courseId;
	}

	public Integer getCourseId() 
	{
		return courseId;
	}
	public void setUserId(Integer userId) 
	{
		this.userId = userId;
	}

	public Integer getUserId() 
	{
		return userId;
	}
	public void setCourseName(String courseName) 
	{
		this.courseName = courseName;
	}

	public String getCourseName() 
	{
		return courseName;
	}
	public void setPicUrl(String picUrl) 
	{
		this.picUrl = picUrl;
	}

	public String getPicUrl() 
	{
		return picUrl;
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

	public String getFileName() {
		return fileName;
	}
public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("courseId", getCourseId())
            .append("userId", getUserId())
            .append("courseName", getCourseName())
            .append("picUrl", getPicUrl())
            .append("pdfUrl", getPdfUrl())
            .append("videoUrl", getVideoUrl())
            .append("remark", getRemark())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
