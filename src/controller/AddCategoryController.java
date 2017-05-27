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
		
		PrintWriter responseWriter = response.getWriter(); //응답을 보내기위한 PrintWriter 객체 생성
		
		JSONObject json = new JSONObject(); //응답 내용을 json 형식으로 담기위한 json 객체 생성
		
		
		try {
			json.put("name", categoryName); //json 객체에 값을 집어넣는다.
			
		} catch (JSONException e) {
			e.printStackTrace();
		}

		String result = json.toString(); //객체를 문자열로 변환시킨다.
		
		responseWriter.println(result); //변환시킨 문자열을 사용자에게 보낸다.

		responseWriter.close(); 
		
		
		
	}

}
