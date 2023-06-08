package com.checki.checkitem.domain;



import lombok.Data;

@Data 
public class CheckItem {
	
	private long idx;

    private String check_class_idx;
    
    private String check_sub_class_idx;
    
    private String check_item;
    
    private String del_yn;
    
    private String create_by;
    
    private String create_dt; 
    
    private String update_by; 
    
    private String update_dt;

    private String check_item_type;
    
    private String check_content;

    

}
