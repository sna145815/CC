package com.checki.checksubclass.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.checki.checksubclass.domain.CheckSubClass;
import com.checki.checksubclass.service.CheckSubClassService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/check-sub-class/*")
@Slf4j 
public class CheckSubClassController {

	@Autowired
    private CheckSubClassService checkSubClassService;
	
	 @PostMapping ("insert")
	    public ResponseEntity <?> insert(@RequestBody  Map<String, String> checkSubClass) 
	    {
	      try {
	  
	        checkSubClassService.insert(checkSubClass.get("check_sub_class"));    
	        log.info("Insert Operation Successful.");
	        return ResponseEntity.ok().body("Insert Operation Successful(Controller)");

	      } catch (Exception e) {
	        log.error("Insert Operation Failed: " + e.getMessage());
	        return ResponseEntity.badRequest().body("Insert Operation Failed(Controller)");
	      }
	    }
	 
	    @GetMapping("find")
	    @ResponseBody 
	    public ResponseEntity<?> findAll(){
	        List<CheckSubClass> result;
	        try{
	           result = checkSubClassService.find();
	           log.info("Insert Operation Successful(Controller).");
	           return ResponseEntity.ok().body(result);
	        }catch(Exception e){
	            log.warn("Get Opereation Failed(Controller)");
	            return ResponseEntity.badRequest().body("Get Opereation Failed");
	        }
	    }

}
