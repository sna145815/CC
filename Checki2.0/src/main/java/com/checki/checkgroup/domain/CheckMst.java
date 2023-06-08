package com.checki.checkgroup.domain;

import lombok.Data;

@Data 
public class CheckMst {
	
	private long idx;
	
	private long check_group_idx;
	
	private char check_period;
	
	private String thing_id;

	private String create_by;
	
	private String create_dt;
	
	private String update_by;
	
	private String update_dt;
	
}
