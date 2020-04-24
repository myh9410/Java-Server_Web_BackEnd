package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import model.ProductDto;
import service.ProductService;
import service.ProductServiceImpl;

/**
 * Servlet implementation class MainControlle
 */
@WebServlet("/main.do")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService productService;	
	
	public void init() {
		productService = new ProductServiceImpl();
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
		if ("mvinsert".equals(act)) {//상품 정보 입력
			path = "/product/insert.jsp";
			redirect(response, path, root);
		} else if ("insert".equals(act)) {
			insertProduct(request, response);
		} else if ("search".equals(act)) {
			searchProduct(request, response,act);
		} else if ("searchCondition".equals(act)) {
			searchProduct(request,response,act);
		} else if ("mvremove".equals(act)) {
			path = "/product/remove.jsp";
			redirect(response, path, root);
		} else if ("remove".equals(act)) {
			removeProduct(request,response);
		}
	}
	private void removeProduct(HttpServletRequest request, HttpServletResponse response) {
		String prod_name = request.getParameter("prod_name");
		try {
			productService.removeProduct(prod_name);
			String path = "/index.jsp";
			String root = request.getContextPath();
			redirect(response, path, root);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void searchProduct(HttpServletRequest request, HttpServletResponse response,String act) {
		if (act.equals("search")) {
			try {
				String key = "";
				String value = "";
				List<ProductDto> list = productService.listProduct(key, value);
				request.setAttribute("products", list);
				String path = "/product/list.jsp";
				forward(request, response, path);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (act.equals("searchCondition")) {
			try {
				String key = request.getParameter("key");
				String value = request.getParameter("value");
				List<ProductDto> list = productService.listProduct(key, value);
				request.setAttribute("products", list);
				String path = "/product/list.jsp";
				forward(request, response, path);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void insertProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String root = request.getContextPath();
		HttpSession session = request.getSession();
		ProductDto productDto = new ProductDto();
		productDto.setProd_name(request.getParameter("prod_name"));
		productDto.setProd_price(Integer.parseInt(request.getParameter("prod_price")));
		productDto.setProd_desc(request.getParameter("prod_desc"));
		String path = "/product/insertsuccess.jsp"; //redirect 경로
		try {
			productService.insertProduct(productDto);
			redirect(response, path, root);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "상품 등록 중 에러 발생!");
			path = "/error/error.jsp";
			forward(request, response, path);
		}
	}

	private void redirect(HttpServletResponse response, String path, String root) throws IOException {
		response.sendRedirect(root+path);
	}
	
	private void forward(HttpServletRequest request, HttpServletResponse response, String path)
			throws ServletException, IOException {
		request.getRequestDispatcher(path).forward(request, response);
	}
}
