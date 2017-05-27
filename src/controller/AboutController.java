package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtilsBean;

import model.dao.AboutDao;
import model.vo.About;

@WebServlet("/AboutController")
public class AboutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String status = request.getParameter("status");
		String url = null;
		
		AboutDao aboutDao = new AboutDao();
		About about = aboutDao.getAbout();
		request.setAttribute("about", about);
		if(status != null)
			url= "./write_about.jsp";
		else
			url= "./about.jsp";
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		About about = new About();
		
		try {
			BeanUtilsBean.getInstance().populate(about, request.getParameterMap());
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
		AboutDao aboutDao = new AboutDao();
		aboutDao.saveAbout(about);
		
		response.sendRedirect("./AboutController");
	}

}
