package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CategoryDao;
import model.vo.Category;


@WebServlet("/SaveCategoryController")
public class SaveCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String categoryName  = request.getParameter("name");
		
		Category category = new Category();
		category.setName(categoryName);
		
		CategoryDao contentDao = new CategoryDao();
		contentDao.saveCategory(category);
	}

}
