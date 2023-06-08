package com.checki.checkclass.controller;

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

import com.checki.checkclass.domain.CheckClass;
import com.checki.checkclass.service.CheckClassService;

import lombok.extern.slf4j.Slf4j;

@RestController 
@RequestMapping("/check-class/*")
@Slf4j 
public class CheckClassController {

	@Autowired 
    private CheckClassService checkClassService;
	
	
	
	@PostMapping ("insert")
    public ResponseEntity <?> insert(@RequestBody Map<String, String> checkClass) 
    {
      try {
        checkClassService.insert(checkClass.get("check_class"));
        log.info("Insert Operation Successful.");
        return ResponseEntity.ok().body("Insert Operation Successful");
      } catch (Exception e) {
        log.error("Insert Opereation Failed: " + e.getMessage());
        return ResponseEntity.badRequest().body("Insert Operation Failed");
      }
    }
	
	@GetMapping("find")
    @ResponseBody 
    public ResponseEntity<?> findAll(){
        List<CheckClass> result;
        try{
            result = checkClassService.find();
            return ResponseEntity.ok().body(result);
        } catch ( Exception e) {
            log.warn("Get Opereation Failed");
            return ResponseEntity.badRequest().body("Get Opereation Failed");
        }
    }
}
