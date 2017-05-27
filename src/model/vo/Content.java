package model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Content {
	private int id;
	private String title;
	private String content;
	private String sub_title;
	private String name;
	private String create_date;
	private int delete_flag;
	private int category_id;
	private String img_url;
	private int view_count;
	private int like_count;
	
}
