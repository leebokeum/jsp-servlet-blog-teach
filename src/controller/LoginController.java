package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.UserDao;
import model.vo.User;


/**
 * Servlet implementation class LoginContoller
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String user_id = request.getParameter("user_id");
		String password = request.getParameter("password");
		String url = null;
		UserDao userDao = new UserDao();
		String confirm_user = userDao.confirmUser(user_id);
		
		if ( confirm_user !=null){
			if (userDao.confirmPassword(user_id, password)){
				User user = userDao.getUser(confirm_user);
				
				request.getSession().setAttribute("user", user);
				request.getSession().setMaxInactiveInterval(100000);
				url ="./BlogListController";
			}else{
				request.setAttribute("confirm", confirm_user+"님의 비밀번호가 틀렸습니다.");
				url = "./login.jsp";
			}

		}else{
			request.setAttribute("confirm", user_id +"이란 사용자가 없습니다.");
			url = "./login.jsp";
		}
		
		if(url.equals("./BlogListController")){
			response.sendRedirect(url);
		}else{
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
		}
	}

}
