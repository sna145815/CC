package com.checki.checkitem.controller;

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


import com.checki.checkitem.domain.CheckItemPlus;
import com.checki.checkitem.service.CheckItemService;

import lombok.extern.slf4j.Slf4j;

@RestController 
@RequestMapping("/check-item/*")
@Slf4j 
public class CheckItemController {

	
	@Autowired 
    private CheckItemService checkItemService;

    
    @GetMapping("find")
    @ResponseBody 
    public ResponseEntity<?> findAll() {
        List<CheckItemPlus> results;
        try{
           results = checkItemService.find();
           results.get(0).getCheck_content();
           log.info("Insert Operation Successful(Controller).");
           return ResponseEntity.ok().body(results);
        } catch(Exception e){
            log.warn("Get Opereation Failed");
            return ResponseEntity.badRequest().body("Get Opereation Failed");
        }
    }
    
    @PostMapping("item-insert")
    public ResponseEntity<?> item(@RequestBody Map<String, String> checkItem) 
    {
      try {
        checkItemService.insert(checkItem);
        log.info("Insert Operation Successful.(Controller)");
        return ResponseEntity.ok().body("Insert Operation Successful");
      } catch (Exception e) {
        log.error("Insert Opereation Failed: " + e.getMessage());
        return ResponseEntity.badRequest().body("Insert Operation Failed");
      }
    }
}
