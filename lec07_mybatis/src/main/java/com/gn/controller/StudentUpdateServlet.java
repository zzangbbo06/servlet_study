package com.gn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.gn.dto.Student;
import com.gn.service.StudentService;

/**
 * Servlet implementation class StudentUpdateServlet
 */
@WebServlet("/student/update")
public class StudentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private StudentService service = new StudentService(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 화면단에서 전달받은 정보 가져오기
		int studentNo = Integer.parseInt(request.getParameter("no"));
		Student student = service.getStudentDetail(studentNo);
		request.setAttribute("student", student);
		request.getRequestDispatcher("/views/studentUpdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 인코딩 처리(utf-8)
		request.setCharacterEncoding("UTF-8");
		// 2. 정보 가져오기(번호, 이름, 나이)
		int studentNo = Integer.parseInt(request.getParameter("studentNo"));
		String studentName = request.getParameter("studentName");
		int studentAge = Integer.parseInt(request.getParameter("studentAge"));
		int result = service.updateStudent(studentNo, studentName, studentAge);
		// 3. service한테 부탁해서 updateStudent
		// 부탁할때는 번호, 이름, 나이 주면서 부탁하고, 
		// 결과는 int형태로 반환
		
		// 4. 만약에 결과가 0보다 크면: 목록 화면 전환 다시 요청
		// 0보다 크지 않다면 : 수정 화면 재요청 -> 반드시 쿼리 스트링 사용!!
		if(result > 0) {
			response.sendRedirect("/student/list");
		}else {
			response.sendRedirect("/student/update?studentNo="+studentNo);
		}
	}

}
