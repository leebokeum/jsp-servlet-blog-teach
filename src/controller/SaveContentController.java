package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtilsBean;

import model.dao.ContentDao;
import model.vo.Content;


@WebServlet("/SaveContentController")
public class SaveContentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Content content = new Content();
		
		try {
			BeanUtilsBean.getInstance().populate(content, request.getParameterMap());
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
		ContentDao contentDao = new ContentDao();
		contentDao.saveContent(content);
		
		response.sendRedirect("./BlogListController");
	}

}
