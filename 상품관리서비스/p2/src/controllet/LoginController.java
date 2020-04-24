package controllet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.SsafyMember;
import service.LoginService;
import service.LoginServiceImpl;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		if(command.equals("login")) {
			String id = request.getParameter("id_from_view");
			String pwd = request.getParameter("pwd_from_view");
			LoginService service = new LoginServiceImpl();
			SsafyMember dto = null;
			try {
				dto = service.login(id, pwd);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			ServletContext context = getServletContext();
			RequestDispatcher dispatch = null;
			if(dto != null && dto.getUserid() != null && !dto.getUserid().trim().equals("")) {//로그인 성공
				HttpSession session = request.getSession();
				session.setAttribute("loginVO", dto);
				dispatch = context.getRequestDispatcher("/prdt_ins.jsp");
				dispatch.forward(request, response);
			}
		}else if(command.equals("logout")) {
			HttpSession session = request.getSession();
			session.invalidate();
			ServletContext context = getServletContext();
			RequestDispatcher dispatch = context.getRequestDispatcher("/login.jsp");
			dispatch.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
