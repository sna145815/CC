package com.checki.checkclass.domain;

import lombok.Data;

@Data 
public class CheckClass {

	private long idx;
	
	private String check_class;
	
	private String del_yn;
	
	private String create_by;
	
	private String create_dt;
	
	private String update_by;
	
	private String update_dt;
}
