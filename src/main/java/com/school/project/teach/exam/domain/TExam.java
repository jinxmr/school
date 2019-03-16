package com.school.project.teach.exam.domain;

import com.school.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.util.Date;

/**
 * 试卷管理表 t_exam
 * 
 * @author ruoyi
 * @date 2019-03-10
 */
public class TExam extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** ID */
	private Integer eId;
	/** 试卷名称 */
	private String eName;
	/** 试卷描述 */
	private String remark;
	/** 试卷状态（0正常1停用） */
	private String status;
	/** 创建者 */
	private String createBy;
	/** 创建时间 */
	private Date createTime;
	/** 更新者 */
	private String updateBy;
	/** 修改时间 */
	private Date updateTime;
	/** 开考时间 */
	private Date startTime;
	/** 结束时间 */
	private Date endTime;
	/** 是否是定时考试 */
	private int isTiming;

	public void setEId(Integer eId) 
	{
		this.eId = eId;
	}

	public Integer getEId() 
	{
		return eId;
	}
	public void setEName(String eName) 
	{
		this.eName = eName;
	}

	public String getEName() 
	{
		return eName;
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

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public int getIsTiming() {
		return isTiming;
	}

	public void setIsTiming(int isTiming) {
		this.isTiming = isTiming;
	}

	public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("eId", getEId())
            .append("eName", getEName())
            .append("remark", getRemark())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
