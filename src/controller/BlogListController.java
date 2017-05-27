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

@WebServlet("/BlogListController")
public class BlogListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String currentPage = request.getParameter("p");
		String c_id = request.getParameter("c_id");
		if(currentPage == null) currentPage = "1";
		int pageSize = 2; // 한 페이지당 게시물 갯수

		ContentDao contentDao = new ContentDao();
		ArrayList<Content> contentList = contentDao.list(currentPage, pageSize, c_id);
		
		int totalPage = contentDao.totalPage(pageSize);
		request.setAttribute("contentList", contentList);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("currentPage", currentPage);
		
		CategoryDao categoryDao = new CategoryDao();
		ArrayList<Category> categoryList = categoryDao.categoryList();
		
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("c_id", c_id);
		
		RequestDispatcher rd = request.getRequestDispatcher("./index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
