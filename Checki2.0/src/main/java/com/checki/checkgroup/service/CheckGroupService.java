package com.checki.checkgroup.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.checki.checkgroup.domain.CheckGroup;
import com.checki.checkgroup.domain.CheckMst;

import lombok.extern.slf4j.Slf4j;

@Service 
@Slf4j 
public class CheckGroupService {
	 @Autowired 
	 CheckGroupDao dao;
	 
	 public void insert(Map<String, String> checkgroup) {
	        try {
	        	
	        	long intUnixTime = (long) System.currentTimeMillis();
	        	
	        	//이미지
	        	CheckGroup cs=new CheckGroup();
	        	
	        	cs.setCheck_group(checkgroup.get("targetname"));
	        	cs.setTag_id(checkgroup.get("tagid"));        	
	       	 	cs.setCreate_by("admin07");
	       	 	cs.setCreate_dt(Long.toString(intUnixTime));
	       	 	cs.setUpdate_by("admin07");
	       	 	cs.setUpdate_dt(Long.toString(intUnixTime));
	        	cs.setCheck_item_idx(checkgroup.get("itemidx"));
	        	cs.setFile_name(checkgroup.get("filename"));
	       	 	//group insert
	       	 	dao.insert(cs);
	       	 	
	       	 	long idx=dao.findById(checkgroup.get("tagid"));
	       	 	
	       	 	//group insert후 idx 값으로 mst삽입
	       	 	CheckMst cm=new CheckMst();
	       	 	cm.setCheck_group_idx(idx);
	       	 	cm.setThing_id(checkgroup.get("tagid"));
	       	 	char period = checkgroup.get("period").charAt(0);
	       	 	cm.setCheck_period(period);
	       	 	cm.setCreate_by("admin07");
	       	 	cm.setCreate_dt(Long.toString(intUnixTime));
	       	 	cm.setUpdate_by("admin07");
	       	 	cm.setUpdate_dt(Long.toString(intUnixTime));
	       	 	
	       	 	dao.cminsert(cm);
	       	 	log.info("OKAY");
	  
	        	
	        } catch (Exception e) {
	            e.printStackTrace();
	            log.warn("QQNPF");
	        }
	    }

	 public List<CheckGroup> find() throws Exception {
	        List<CheckGroup> result = new ArrayList<>();
	        result = dao.find();

	        try {
	        	 String pattern="yyyy-MM-dd HH:mm:ss";
	         	 SimpleDateFormat formatter=new SimpleDateFormat(pattern);

	             for(int i=0;i<result.size();i++) {

	                 String dt=result.get(i).getUpdate_dt();
	                 long unixTimestamp = Long.parseLong(dt);

	                 Date  date = new Date(unixTimestamp);
	                 String formatedDate = formatter.format(date);
	         		 result.get(i).setUpdate_dt(formatedDate.toString());

	                 String c_dt=result.get(i).getCreate_dt();
	                 long unixTimestamp2 = Long.parseLong(c_dt);
	  
	                 Date  date2 = new Date(unixTimestamp2);
	                 String formatedDate2 = formatter.format(date2);
	         		result.get(i).setCreate_dt(formatedDate2.toString());   
	            }
	        }
	         catch(Exception e){
	        	 e.printStackTrace();
	        }
	        return result;
	    }
}
