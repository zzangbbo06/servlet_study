package com.gn.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.gn.common.SessionTemplate;
import com.gn.dto.Student;

public class StudentDao {
	public List<Student> selectAll(){
		// 데이터베이스 접근(MyBatis)
		SqlSession session = SessionTemplate.getSqlSession(true);
//		session.selectList("매퍼의 위치.메소드명", "전달하는 파라미터");
		List<Student>list = session.selectList("com.gn.mapper.StudentMapper.selectAll");
		session.close();
		return list;
	}
}
