package com.school.project.teach.exam.service;

import com.school.common.support.Convert;
import com.school.common.utils.UUIDUtil;
import com.school.project.teach.exam.domain.TExam;
import com.school.project.teach.exam.domain.TExamQuestion;
import com.school.project.teach.exam.domain.Testquestion;
import com.school.project.teach.exam.mapper.TExamMapper;
import com.school.project.teach.exam.mapper.TExamQuestionMapper;
import com.school.project.teach.exam.mapper.TestquestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 试卷管理 服务层实现
 * 
 * @author ruoyi
 * @date 2019-03-10
 */
@Service
public class TExamServiceImpl implements ITExamService 
{
	@Autowired
	private TExamMapper tExamMapper;

	@Autowired
	private TestquestionMapper testquestionMapper;

	@Autowired
	private TExamQuestionMapper tExamQuestionMapper;

	/**
     * 查询试卷管理信息
     * 
     * @param eId 试卷管理ID
     * @return 试卷管理信息
     */
    @Override
	public TExam selectTExamById(String eId)
	{
	    return tExamMapper.selectTExamById(eId);
	}
	
	/**
     * 查询试卷管理列表
     * 
     * @param tExam 试卷管理信息
     * @return 试卷管理集合
     */
	@Override
	public List<TExam> selectTExamList(TExam tExam)
	{
	    return tExamMapper.selectTExamList(tExam);
	}
	
    /**
     * 新增试卷管理
     * 
     * @param tExam 试卷管理信息
     * @return 结果
     */
	@Override
	public int insertTExam(TExam tExam,int xnum, int xsrore, int pnum, int psrore)
	{
		//接收到参数，开始组题
		//查询题库 判断选择分别查询
		//查询选择题
		tExam.setEId(UUIDUtil.getUUID());
		List<Testquestion> testquestionList = testquestionMapper.selectTTestquestionListByQType(0);
		List<TExamQuestion> listchoose = new ArrayList<>();
		//判断 如果传过来的题数大于等于数据库里查出的题述，则默认将数据库查出的题数全部加载到该试卷中，判断题同理
		if(xnum > testquestionList.size()) {
			return 0;
		} else {
			ArrayList nums = getRanom(testquestionList.size()-1, xnum);
			for(int i=0;i<nums.size();i++) {
				TExamQuestion choose = new TExamQuestion();
				//根据随机生成的数去获取选择题的ID并放入中间对象中
				choose.setQId(testquestionList.get((Integer) nums.get(i)).getQId());
				choose.setEId(tExam.getEId());
				//将生成的在中间表数据存入List
				listchoose.add(choose);
			}
		}
		List<Testquestion> testjudgeList = testquestionMapper.selectTTestquestionListByQType(1);
		if(pnum > testjudgeList.size()) {
			return 0;
		} else {
			ArrayList nums = getRanom(testjudgeList.size()-1, pnum);
			for(int i=0;i<nums.size();i++) {
				TExamQuestion judge = new TExamQuestion();
				//根据随机生成的数去获取选择题的ID并放入中间对象中
				judge.setQId(testjudgeList.get((Integer) nums.get(i)).getQId());
				judge.setEId(tExam.getEId());
				//将生成的在中间表数据存入List
				listchoose.add(judge);
			}
		}
		tExam.seteScore(xnum*xsrore+pnum*psrore);
		//批量插入中间表
		tExamQuestionMapper.insertList(listchoose);
	    return tExamMapper.insertTExam(tExam);
	}

	/**
	 * 生成随机整数，取题
	 */
	private ArrayList getRanom(int qSize, int xnum) {
		// 创造产生随机数的对象
		Random r = new Random();
		// 创建一个存储随机数的集合
		ArrayList<Integer> array = new ArrayList<Integer>();
		// 定义一个统计变量，从0开始
		int count = 0;
		// 判断统计变量是否小于10
		while (count < xnum) {
			// 先产生一个随机数
			int number = r.nextInt(qSize) + 1;
			// 判断该随机数在集合中是否存在
			if (!array.contains(number)) {
				// 如果不存在：就添加，统计变量++
				array.add(number);
				count++;
			}
		}
		// 增强for进行遍历。格式：for（元素数据类型 变量： 数组或者集合）
		for (Integer i : array) {
		}
		return array;
	}
	
	/**
     * 修改试卷管理
     * 
     * @param tExam 试卷管理信息
     * @return 结果
     */
	@Override
	public int updateTExam(TExam tExam)
	{
	    return tExamMapper.updateTExam(tExam);
	}

	/**
     * 删除试卷管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTExamByIds(String ids)
	{
		//删除试卷之前要先删除试卷下的关联试题
		tExamQuestionMapper.deleteTExamQuestionByExamIds(Convert.toStrArray(ids));
		return tExamMapper.deleteTExamByIds(Convert.toStrArray(ids));
	}
	
}
