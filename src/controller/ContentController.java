package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CategoryDao;
import model.dao.ContentDao;
import model.vo.Category;
import model.vo.Content;

@WebServlet("/ContentController")
public class ContentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		ContentDao contentDao = new ContentDao();
		Content content = contentDao.getContent(Integer.parseInt(id));
		request.setAttribute("content", content);
		
		CategoryDao categoryDao = new CategoryDao();
		ArrayList<Category> categoryList = categoryDao.categoryList();
		
		request.setAttribute("categoryList", categoryList);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("./post.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
