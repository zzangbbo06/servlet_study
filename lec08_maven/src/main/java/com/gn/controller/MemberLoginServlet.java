package com.gn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import org.json.simple.JSONObject;

import com.gn.dto.Member;
import com.gn.service.MemberService;

/**
 * Servlet implementation class MemberLoginServlet
 */
@WebServlet("/memberLogin")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MemberService service = new MemberService();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/member/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(">> doPost 실행됨");  // 🔥 추가
		request.setCharacterEncoding("UTF-8");
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		
		// 전달받은 정보가 일치하는 회원 반환
		Member member = service.selectMember(memberId, memberPw);
		// 1. service : 바구니 옮겨담아서 dao한테 전달하기
		// 2. dao : 인터페이스한테 db 연결 요청하기
		// 3. Mapper : mapper.xml한테 쿼리 호출하기
		// 4. xml : select 구성 + resultMap(memberResultMap)
		
		JSONObject obj = new JSONObject();
		obj.put("res_code", "500");
		obj.put("res_msg","로그인 중 오류가 발생하였습니다.");
		
		
		// new Member()로 하면 안에 값이 비었는가 안비었는가로 해야함 이름이 비어잇고 비밀번호가 비어있으면
		if (member != null) {	
			HttpSession session = request.getSession(true);
			session.setAttribute("loginMember", member);
			session.setMaxInactiveInterval(60 * 30); // 30분저장
			
			obj.put("res_code", "200");
			obj.put("res_msg", "정상적으로 로그인되었습니다.");
		}
		
		
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(obj.toString());
		
		
	}

}
