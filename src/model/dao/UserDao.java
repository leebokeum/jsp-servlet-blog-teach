package model.dao;

import model.vo.User;

public class UserDao {     //data access object

	private DBConnectionORM connect;

	public UserDao(){
		connect = new DBConnectionORM();
	}
	
	public String confirmUser(String user_id){
		User user = connect.queryForObject("getUser", user_id);
		if(user != null){
			return user.getUser_id();
		}else{
			return null;
		}
	}

	public boolean confirmPassword (String user_id, String password){
		User user1 = new User(user_id, password);
		User user = connect.queryForObject("confirmPassword", user1);
		
		if(user == null){
			return false;
		}else{
			return true;
		}
	}

	public void join (User user){
		connect.update("join", user);
	}
	
	public User getUser (String id){
		User user = connect.queryForObject("getUser", id);
		return user;
	}
}
