package com.school.project.teach.exam.domain;

import com.school.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 试卷试题中间表 t_exam_question
 * 
 * @author ruoyi
 * @date 2019-03-20
 */
public class TExamQuestion extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 试题ID */
	private String qId;
	/** 试卷ID */
	private String eId;

	public void setQId(String qId) 
	{
		this.qId = qId;
	}

	public String getQId() 
	{
		return qId;
	}
	public void setEId(String eId)
	{
		this.eId = eId;
	}

	public String getEId()
	{
		return eId;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("qId", getQId())
            .append("eId", getEId())
            .toString();
    }
}
