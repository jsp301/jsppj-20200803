package uploadFile;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadServlet
 */
//@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");

		PrintWriter writer = resp.getWriter();
		writer.println("<html><body>");

		String contentType = req.getContentType();

		// 요청 컨텐츠 타입이 multipart/form-data 인지 확인
		if (contentType != null & contentType.toLowerCase().startsWith("multipart/")) {
			printPartInfo(req, writer);
		} else {
			writer.println("multipart가 아님");
		}
		writer.println("</body></html>");
	}

	private void printPartInfo(HttpServletRequest req, PrintWriter writer) throws IOException, ServletException {
		// Part 목록을 구한다.
		Collection<Part> parts = req.getParts();

		for (Part part : parts) {
			// Part의 이름 구하고 출력
			writer.println("<br/> name = " + part.getName());
			// Part의 contentType 구하고 출력
			String contentType = part.getContentType();
			writer.println("<br/> contentType = " + contentType);
			// 파일인경우 /Content-Disposition 헤더가 "filename=" 포함하고 있을시 파일에 해당 /업로드한 파일 데이터처리
			if (part.getHeader("Content-Disposition").contains("filename=")) {
				writer.println("<br/> size = " + part.getSize());
				String fileName = part.getSubmittedFileName();
				writer.println("<br/> filename = " + fileName);

				// getSize()메서드로 업로드 파일 존재여부 확인
				if (part.getSize() > 0) {
					// 업로드한 데이터를 filename에 해당하는 파일에 쓴다.
					part.write("c:/tempfiles-netfilx/" + fileName);
					part.delete();
				}
				// 파일아닌경우 / 파라미터 값 구한다.
			} else {
				String value = req.getParameter(part.getName());
				writer.println("<br/> value = " + value);
			}

			writer.println("<hr/>");
		}
	}
}
