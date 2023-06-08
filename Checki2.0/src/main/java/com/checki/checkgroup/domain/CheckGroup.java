package com.checki.checkgroup.domain;

import lombok.Data;

@Data 
public class CheckGroup {
	
	private long idx;
	
	private String check_group;
	
	private String del_yn;
	
	private String create_by;
	
	private String create_dt;
	
	private String update_by;
	
	private String update_dt;
	
	private String file_name;
	
	private String file_path;
	
	private String file_size;
	
	private String check_item_idx;
	
	private String tag_id;
	

}
