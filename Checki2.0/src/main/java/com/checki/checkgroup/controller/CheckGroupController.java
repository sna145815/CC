package com.checki.checkgroup.controller;

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

import com.checki.checkgroup.domain.CheckGroup;
import com.checki.checkgroup.service.CheckGroupService;

import lombok.extern.slf4j.Slf4j;

@RestController  
@RequestMapping("/target/*")
@Slf4j 
public class CheckGroupController {

	@Autowired
    private CheckGroupService checkGroupService;

	@PostMapping("insert")
    public ResponseEntity<?> insert(@RequestBody Map<String, String> checkgroup) 
    {
      try {
    	  checkGroupService.insert(checkgroup);
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
        List<CheckGroup> result;
        try{
            result = checkGroupService.find();
            log.info("Insert Operation Successful.");
            return ResponseEntity.ok().body(result);
        } catch ( Exception e) {
            log.warn("Get Opereation Failed");
            return ResponseEntity.badRequest().body("Get Opereation Failed");
        }
    }
}
