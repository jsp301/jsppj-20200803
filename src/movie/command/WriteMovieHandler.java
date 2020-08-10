package movie.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import auth.service.User;
import movie.service.WriteFileService;
import movie.service.WriteMovieService;
import movie.service.WriteRequest;
import mvc.controller.CommandHandler;

public class WriteMovieHandler implements CommandHandler {

	private static final String FORM_VIEW ="/WEB-INF/view/newMovieForm.jsp";
	private WriteMovieService writeService = new WriteMovieService();
	private WriteFileService writeFile = new WriteFileService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {
		//equalsIgnoreCase : 대소문자 구분 없이 비교
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, req);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, req);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}
	

	
	private String processForm(HttpServletRequest req, HttpServletRequest req2) {
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletRequest req2) 
	throws Exception {
		
//		WriteRequest writeReq =  new WriteRequest(null, 
//				req.getParameter("title"), 
//				req.getParameter("director"), 
//				req.getParameter("genre"),
//				req.getParameter("releaseDate"));
		
		// 웹에서 저장한 파일 가져오기
		Part filePart = req.getPart("file1");
		String fileName = filePart.getSubmittedFileName();
		
		fileName = fileName == null ? "" : fileName;
		
		// 에러 체크
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);

		
		//authUser -> auth->LoginHandler
		//getSession(false) - HttpSession이 존재하면 현재 HttpSession을 반환하고 존재하지 않으면 새로 생성하지 않고 그냥 null을 반환합니다.
		WriteRequest writeReq = createWriteRequest(req, fileName);
		writeReq.validate(errors);
		
		if(!errors.isEmpty()) {
			return FORM_VIEW;
		}
		//WriteMovieService
		int newMovieNo = writeService.write(writeReq);
		
		
		if (!(fileName == null 
				|| fileName.isEmpty() 
				|| filePart.getSize() == 0 )) {
			//WriteFileService
			writeFile.write(filePart, newMovieNo);
		}
		
		req.setAttribute("newMovieNo", newMovieNo);
		
		return "/WEB-INF/view/newMovieSuccess.jsp";
	}


	
	private WriteRequest createWriteRequest(
			HttpServletRequest req) {
		return createWriteRequest(req, "");
	}
	
	//웹에서 입력하는 데이터들로 새로운 WriteRequest 생성
	private WriteRequest createWriteRequest(
			HttpServletRequest req, String fileName) {
		
		return new WriteRequest(
				null, 
				req.getParameter("title"),
				req.getParameter("director"), 
				req.getParameter("genre"),
				req.getParameter("releaseDate"),
				fileName);		
	}
	

}
