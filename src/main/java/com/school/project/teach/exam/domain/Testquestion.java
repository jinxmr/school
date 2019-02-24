package com.school.project.teach.exam.domain;

import com.school.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.util.Date;

/**
 * 试题管理表 t_testquestion
 * 
 * @author ruoyi
 * @date 2019-02-23
 */
public class Testquestion extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 试题ID */
	private Integer qId;
	/** 题目名称 */
	private String qName;
	/** 序号，试题排序 */
	private Integer qNo;
	/** 试题类型,1：单选，2：判断 */
	private Integer qType;
	/** 分值 */
	private Integer qScore;
	/** 创建时间 */
	private Date createTime;
	/** 创建者 */
	private String createUser;
	/** 修改时间 */
	private Date updateTime;
	/** 修改者 */
	private String updateUser;

	public void setQId(Integer qId) 
	{
		this.qId = qId;
	}

	public Integer getQId() 
	{
		return qId;
	}
	public void setQName(String qName) 
	{
		this.qName = qName;
	}

	public String getQName() 
	{
		return qName;
	}
	public void setQNo(Integer qNo) 
	{
		this.qNo = qNo;
	}

	public Integer getQNo() 
	{
		return qNo;
	}
	public void setQType(Integer qType) 
	{
		this.qType = qType;
	}

	public Integer getQType() 
	{
		return qType;
	}
	public void setQScore(Integer qScore) 
	{
		this.qScore = qScore;
	}

	public Integer getQScore() 
	{
		return qScore;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}
	public void setCreateUser(String createUser) 
	{
		this.createUser = createUser;
	}

	public String getCreateUser() 
	{
		return createUser;
	}
	public void setUpdateTime(Date updateTime) 
	{
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() 
	{
		return updateTime;
	}
	public void setUpdateUser(String updateUser) 
	{
		this.updateUser = updateUser;
	}

	public String getUpdateUser() 
	{
		return updateUser;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("qId", getQId())
            .append("qName", getQName())
            .append("qNo", getQNo())
            .append("qType", getQType())
            .append("qScore", getQScore())
            .append("createTime", getCreateTime())
            .append("createUser", getCreateUser())
            .append("updateTime", getUpdateTime())
            .append("updateUser", getUpdateUser())
            .toString();
    }
}
