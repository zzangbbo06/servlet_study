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
		session.close(); // 반드시 해줘야함.
		return list;
	}
	
	public Student selectOne(int studentNo) {
		SqlSession session = SessionTemplate.getSqlSession(true);
		Student student = session.selectOne("com.gn.mapper.StudentMapper.selectOne", studentNo);
		session.close();
		return student;
	}
	public List<Student> selectName(String studentName) {
		SqlSession session = SessionTemplate.getSqlSession(true);
		List<Student> student = session.selectList("com.gn.mapper.StudentMapper.selectName", studentName);
		// selectOne은 메소드임 
		session.close();
		return student;
	}
	public int insert(Student param) {
		SqlSession session = SessionTemplate.getSqlSession(true);
		int result = session.insert("com.gn.mapper.StudentMapper.insert", param);
		// 넘겨줘야하는 필요한 정보가 있다면 두번째에 적어줄것
		session.close();
		return result;
	}
	
	// Service한테 Student를 전달 받았어요
	// 전달받은 정보를 가지고 update를 하고 싶어요. 
	public int update(Student param) {
		SqlSession session = SessionTemplate.getSqlSession(true);
		int result = session.update("com.gn.mapper.StudentMapper.updateStudent", param);
		session.close();
		return result;
	}
	public int deleteStudent(Student param) {
		SqlSession session = SessionTemplate.getSqlSession(true);
		int result = session.delete("com.gn.mapper.StudentMapper.delete", param);
		session.close();
		return result;
	}
}
