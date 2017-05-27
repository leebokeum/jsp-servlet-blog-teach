package model.dao;

import model.vo.About;

public class AboutDao {
	private DBConnectionORM connect;
	public AboutDao(){
		connect = new DBConnectionORM();
	}
	public About getAbout() {
		About about = connect.queryForObject("getAbout");
		return about;
	}
	public void saveAbout(About about) {
		connect.update("saveAbout", about);
	}
}
