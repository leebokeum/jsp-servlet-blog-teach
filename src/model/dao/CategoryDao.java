package model.dao;

import java.util.ArrayList;

import model.vo.Category;

public class CategoryDao {
	
	private DBConnectionORM connect;

	public CategoryDao(){
		connect = new DBConnectionORM();
	}
	
	public void saveCategory(Category category){
		connect.update("saveCategory", category);
	}
	
	public ArrayList<Category> categoryList() {
		ArrayList<Category> categoryList = connect.queryForList("getCategoryList");
		return categoryList;
	}
}
