package model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	int id;
	String user_id;
	String password;
	String create_date;
	int age;
	String name;
	String local;
	String hobby;
	String img_url;
	int delete_flag;
	String birthday;
	
	public User(String user_id, String password) {
		this.user_id = user_id;
		this.password = password;
	}
}
