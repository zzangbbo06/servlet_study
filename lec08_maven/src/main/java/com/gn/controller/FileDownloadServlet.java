package com.gn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import com.gn.dto.Attach;
import com.gn.service.BoardService;

/**
 * Servlet implementation class FileDownloadServlet
 */
@WebServlet("/fileDownLoad")
public class FileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService service = new BoardService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileDownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int attachNo = Integer.parseInt(request.getParameter("no"));
		Attach attach = service.selectAttachByAttachNo(attachNo);
		
		// 2. 유효성 검사
		String filePath = "C:\\upload\\board\\"+attach.getReName();
		// 2. 파일 정보가 없는 경우 에러 발생
				if(filePath == null || filePath.trim().equals("")) {
					response.sendError(HttpServletResponse.SC_BAD_REQUEST);
					return;
				}
				
				// 3. 파일이 존재하는지 확인
				File file = new File(filePath);
				if(!file.exists()) {
					response.sendError(HttpServletResponse.SC_NOT_FOUND);
					return;
				}
				// 4. 다운로드용 응답 헤어 설정
				response.setContentType("application/octet-stream");
				response.setContentLength((int)file.length());
				
				// 5. 파일명 인코딩
				String encodedName = URLEncoder.encode(attach.getOriName(), "UTF-8").replaceAll("\\+", "%20");
				response.setHeader("Content-Disposition", "attachment; filename=\""+encodedName+"\"");
				
				// 6. 파일 데이터 전송
				try(FileInputStream fis = new FileInputStream(file);
						OutputStream out = response.getOutputStream();	
							){
						byte[] buffer = new byte[1024];
						int byteRead;
						while((byteRead = fis.read(buffer)) != -1) {
							out.write(buffer,0,byteRead);
						}
					}
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
