package com.school.project.teach.answer.domain;

import com.school.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 试题答案表 t_answer
 * 
 * @author ruoyi
 * @date 2019-02-27
 */
public class TAnswer extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** ID */
	private Integer sId;
	/** 选项内容 */
	private String sName;
	/** 是否为正确答案,0：是，1：否 */
	private Integer isRight;
	/**  */
	private String qId;
	/** 选项顺序，按照先后顺序系统自动排序，为标准卷使用。 */
	private Integer sSort;

	public void setSId(Integer sId) 
	{
		this.sId = sId;
	}

	public Integer getSId() 
	{
		return sId;
	}
	public void setSName(String sName) 
	{
		this.sName = sName;
	}

	public String getSName() 
	{
		return sName;
	}
	public void setIsRight(Integer isRight) 
	{
		this.isRight = isRight;
	}

	public Integer getIsRight() 
	{
		return isRight;
	}
	public void setQId(String qId)
	{
		this.qId = qId;
	}

	public String getQId()
	{
		return qId;
	}
	public void setSSort(Integer sSort) 
	{
		this.sSort = sSort;
	}

	public Integer getSSort() 
	{
		return sSort;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("sId", getSId())
            .append("sName", getSName())
            .append("isRight", getIsRight())
            .append("qId", getQId())
            .append("sSort", getSSort())
            .toString();
    }
}
