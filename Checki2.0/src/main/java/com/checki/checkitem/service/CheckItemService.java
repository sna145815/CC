package com.checki.checkitem.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.checki.checkclass.domain.CheckClass;
import com.checki.checkclass.service.CheckClassService;
import com.checki.checkitem.domain.CheckItem;
import com.checki.checkitem.domain.CheckItemPlus;
import com.checki.checksubclass.domain.CheckSubClass;
import com.checki.checksubclass.service.CheckSubClassService;

import lombok.extern.slf4j.Slf4j;

@Service 
@Slf4j 
public class CheckItemService {

	@Autowired 
    CheckItemDao checkItemDao;
	
	@Autowired
    CheckClassService checkClassService;
 
    @Autowired
    CheckSubClassService checkSubClassService;
	
	 public List<CheckItemPlus> find() {
	        List<CheckItemPlus> result = new ArrayList<>();
	        
	        result = checkItemDao.find();

	        try {
	        	
	            String pattern="yyyy-MM-dd HH:mm:ss";
	        	SimpleDateFormat formatter=new SimpleDateFormat(pattern);

	        	for(int i=0;i<result.size();i++) {
	                long unixTimestamp = Long.parseLong(result.get(i).getUpdate_dt());

	                Date date = new Date(unixTimestamp);
	                String formatedDate = formatter.format(date);
	        		result.get(i).setUpdate_dt(formatedDate.toString());

	                long unixTimestamp2 = Long.parseLong(result.get(i).getCreate_dt());
	 
	                Date  date2 = new Date(unixTimestamp2);
	                String formatedDate2 = formatter.format(date2);
	        		result.get(i).setCreate_dt(formatedDate2.toString());

	                int classId = Integer.parseInt(result.get(i).getCheck_class_idx());
	                CheckClass checkClass = checkClassService.findById(classId);
	                result.get(i).setCheckClass(checkClass);

	                int subClassId = Integer.parseInt(result.get(i).getCheck_sub_class_idx());
	                CheckSubClass checkSubClass = checkSubClassService.findById(subClassId);
	                result.get(i).setCheckSubClass(checkSubClass);                  
	        	 }
	        	log.info("Insert Operation Successful(ServiceLayer).");
	        	 
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	            log.error("Insert Opereation Failed: " + e.getMessage());
	        }
	        
	        return result;
	    }
	
	public void insert(Map<String, String> checkItem) {
        try{
        	
        	CheckItem  ci=new CheckItem();
        	
        	long intUnixTime = (long) System.currentTimeMillis();       
        	
        	ci.setCheck_item(checkItem.get("check_item"));
        	ci.setCheck_class_idx(checkItem.get("check_class_idx"));
        	ci.setCheck_sub_class_idx(checkItem.get("check_sub_class_idx"));
        	ci.setCheck_content(checkItem.get("check_content"));
        	//ci.setCheck_item_type();	
        	ci.setCreate_by("admin07");
       	 	ci.setCreate_dt(Long.toString(intUnixTime));
       	 	ci.setUpdate_by("damin07");
       	 	ci.setUpdate_dt(Long.toString(intUnixTime));
        	
       	 	checkItemDao.insert(ci);
       	 	log.info("Insert Operation Successful(ServiceLayer).");
        	
        } catch(Exception e){
            log.error("Insert Opereation Failed: " + e.getMessage());
        }

    }

}
