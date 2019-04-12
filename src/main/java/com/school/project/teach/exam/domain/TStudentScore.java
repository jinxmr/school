package com.school.project.teach.exam.domain;

import com.school.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.util.Date;

/**
 * 学生考试得分表 t_student_score
 * 
 * @author ruoyi
 * @date 2019-04-11
 */
public class TStudentScore extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** ID */
	private Integer id;
	/** 试卷ID */
	private String examId;
	/** 得分 */
	private Integer sumScore;
	/** 考试人姓名 */
	private String examUsername;
	/** 考试人ID */
	private Integer examUserid;
	/** 考试时间 */
	private Date examTime;
	/** 试卷名称 **/
	private TExam exam;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setExamId(String examId) 
	{
		this.examId = examId;
	}

	public String getExamId() 
	{
		return examId;
	}
	public void setSumScore(Integer sumScore) 
	{
		this.sumScore = sumScore;
	}

	public Integer getSumScore() 
	{
		return sumScore;
	}
	public void setExamUsername(String examUsername)
	{
		this.examUsername = examUsername;
	}

	public String getExamUsername()
	{
		return examUsername;
	}
	public void setExamUserid(Integer examUserid)
	{
		this.examUserid = examUserid;
	}

	public Integer getExamUserid() 
	{
		return examUserid;
	}
	public void setExamTime(Date examTime) 
	{
		this.examTime = examTime;
	}

	public Date getExamTime() 
	{
		return examTime;
	}

	public TExam getExam() {
		return exam;
	}

	public void setExam(TExam exam) {
		this.exam = exam;
	}

	public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("examId", getExamId())
            .append("sumScore", getSumScore())
            .append("examUsername", getExamUsername())
            .append("examUserid", getExamUserid())
            .append("examTime", getExamTime())
            .toString();
    }
}
