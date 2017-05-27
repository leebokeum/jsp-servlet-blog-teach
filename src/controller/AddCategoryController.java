package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import model.dao.CategoryDao;
import model.vo.Category;

@WebServlet("/AddCategoryController")
public class AddCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String categoryName = request.getParameter("name");
		
		Category category = new Category();
		
		category.setName(categoryName);
		category.setId(2);
		category.setCount(0);
		
		CategoryDao categoryDao = new CategoryDao();
		categoryDao.saveCategory(category);

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		PrintWriter responseWriter = response.getWriter(); //������ ���������� PrintWriter ��ü ����
		
		JSONObject json = new JSONObject(); //���� ������ json �������� ������� json ��ü ����
		
		
		try {
			json.put("name", categoryName); //json ��ü�� ���� ����ִ´�.
			
		} catch (JSONException e) {
			e.printStackTrace();
		}

		String result = json.toString(); //��ü�� ���ڿ��� ��ȯ��Ų��.
		
		responseWriter.println(result); //��ȯ��Ų ���ڿ��� ����ڿ��� ������.

		responseWriter.close(); 
		
		
		
	}

}
