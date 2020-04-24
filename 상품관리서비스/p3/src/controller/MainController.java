package controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.MemberDto;
import dto.PhoneDto;
import service.LoginService;
import service.LoginServiceImpl;
import service.PhoneService;
import service.PhoneServiceImpl;



@WebServlet("/main.do")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private LoginService loginService;
	private PhoneService phoneService;
	
	public void init() {
		loginService = new LoginServiceImpl();
		phoneService = new PhoneServiceImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		process(request, response);		
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String root = request.getContextPath();
		String path = "/index.jsp";
		String act = request.getParameter("act");
		if ("mvjoin".equals(act)) {//로그인 화면에서 회원가입 버튼 클릭 시
			path = "/user/join.jsp";
			redirect(response, path, root);
		} else if ("login".equals(act)) {//로그인
			login(request, response);
		} else if ("logout".equals(act)) {//로그아웃
			logout(request, response);
		} else if ("mvphonereg".equals(act)) {//로그아웃
			path = "/phone/PhoneReg.jsp";
			redirect(response, path, root);
		} else if ("phonereg".equals(act)) {//로그아웃
			phonereg(request, response);
		} else if ("cancel".equals(act)) {//로그아웃
			path = "/index.jsp";
			redirect(response, path, root);
		} else if ("mvphonelist".equals(act)) {//로그아웃
			searchMember(request, response);
		} else if ("remove".equals(act)) {//로그아웃
			remove(request, response);
		}
	}

	private void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] tmp = request.getParameterValues("checker");
		
		try {
			List<PhoneDto> list = phoneService.remove(tmp);
			request.setAttribute("phones", list);
			String path = "/phone/PhoneList.jsp";
			forward(request, response, path);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "핸드폰 목록을 찾을 수 없습니다.");
			String path = "/error/error.jsp";
			forward(request, response, path);
		}
	}

	private void searchMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<PhoneDto> list = phoneService.getlist();
			request.setAttribute("phones", list);
			String path = "/phone/PhoneList.jsp";
			forward(request, response, path);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "핸드폰을 찾을 수 없습니다.");
			String path = "/error/error.jsp";
			forward(request, response, path);
		}
	}

	private void phonereg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("함수접근");
		PhoneDto phoneDto = new PhoneDto();
		phoneDto.setNum(request.getParameter("num"));
		phoneDto.setModel(request.getParameter("model"));
		phoneDto.setPrice(Integer.parseInt(request.getParameter("num")));
		phoneDto.setVcode(request.getParameter("vcode"));
		try {
			phoneService.register(phoneDto);
			String path = "/phone/Result.jsp";
			forward(request, response, path);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "핸드폰을 등록할 수 없습니다.");
			String path = "/error/error.jsp";
			forward(request, response, path);
		}
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String path = "/index.jsp";
		String root = request.getContextPath();
		HttpSession session = request.getSession();
		session.invalidate();
		redirect(response, path, root);
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/index.jsp";
		String userid = request.getParameter("userid");
		String userpwd = request.getParameter("userpwd");
		
		try {
			MemberDto memberDto = loginService.login(userid, userpwd);
			if (memberDto != null) {//로그인 성공
				/////////////////////// session ///////////////////////
				HttpSession session = request.getSession();
				session.setAttribute("userinfo", memberDto);
				///////////////////////////////////////////////////////
				////////////////////// cookie /////////////////////////
				//로그인 성공 시 쿠키 생성
				String idsv = request.getParameter("idsave");
				if ("saveok".equals(idsv)) { // 아이디 저장 체크
					Cookie cookie = new Cookie("ssafy_id", userid); // 쿠키 이름, 저장할 값
					cookie.setPath(request.getContextPath());
					cookie.setMaxAge(60*60*24*365); // 1년 설정
					response.addCookie(cookie);	
				} else { // 체크 해제
					Cookie cookies[] = request.getCookies();
					if (cookies != null){
						for (Cookie cookie : cookies){
							if (cookie.getName().equals("ssafy_id")){
								cookie.setPath(request.getContextPath());
								cookie.setMaxAge(0);
								response.addCookie(cookie);
								break;
							}
						}
					}
				}
				///////////////////////////////////////////////////////
			}else {//실패
				request.setAttribute("msg", "아이디 또는 비밀번호를 확인해 주세요.");			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		forward(request, response, path);
	}

	private void forward(HttpServletRequest request, HttpServletResponse response, String path)
			throws ServletException, IOException {
		request.getRequestDispatcher(path).forward(request, response);
	}
	
	private void redirect(HttpServletResponse response, String path, String root) throws IOException {
		response.sendRedirect(root+path);
	}
	
}
