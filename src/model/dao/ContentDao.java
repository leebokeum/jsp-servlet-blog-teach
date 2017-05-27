package model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import model.vo.Content;

public class ContentDao {
	private DBConnectionORM connect;
	

	public ContentDao(){
		connect = new DBConnectionORM();
	}

	public void saveContent (Content content){
		connect.insert("saveContent", content);
	}

	public void deleteContent (int id){
		connect.update("deleteContent", id);
	}

	public ArrayList<Content> list(String currentPage, int pageSize, String c_id) {
		HashMap<String, String> map = new HashMap<>();
		map.put("currentPage", currentPage);
		map.put("size", String.valueOf(pageSize));
		map.put("c_id", c_id);
		ArrayList<Content> contentList = connect.queryForList("getList", map);
		return contentList;
	}


	public Content getContent(int id){
		Content content = connect.queryForObject("getContent", id);
		return content;
	}


	public void updateContent(Content content) {
		connect.update("updateContent", content);
	}


	public int totalPage(int pageSize){

		/*전체 게시글 합계 가져오기*/
		int total = (Integer) connect.queryForObject("getCount");

		/*전체 페이지 갯수 구하기 (pageSize는 한페이지에 표시될 리스트 숫자)*/
		int totalPage = total / pageSize;
		if(total % pageSize > 0) totalPage++;

		return totalPage;
	}
}
