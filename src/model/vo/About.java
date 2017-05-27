package model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class About {
	private int id;
	private String title;
	private String sub_title;
	private String content;
	private String create_date;
}
