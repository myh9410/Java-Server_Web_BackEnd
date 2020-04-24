package controllet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		if(command.equals("prdt_ins")) {
			String prdt_name = request.getParameter("prdt_name");
			String prdt_price = request.getParameter("prdt_price");
			String prdt_desc = request.getParameter("prdt_desc");
			//int successCnt = service.insert(prdt_name, prdt_price, prdt_desc);// -> dao.insert(prdt_name, prdt_price, prdt_desc)
			//if(successCnt == 1){
			Cookie cookie1 = new Cookie("prdt_name", prdt_name);
			Cookie cookie2 = new Cookie("prdt_price", prdt_price);
			Cookie cookie3 = new Cookie("prdt_desc", prdt_desc);
			response.addCookie(cookie1);
			response.addCookie(cookie2);
			response.addCookie(cookie3);
			//}
			ServletContext context = getServletContext();
			RequestDispatcher dispatch = null;
			dispatch = context.getRequestDispatcher("/login.jsp");
			dispatch.forward(request, response);
		}else if(command.equals("prdt_del")) {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
