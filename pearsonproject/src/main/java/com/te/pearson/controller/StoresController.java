package com.te.pearson.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.te.pearson.bean.ResponseBean;
import com.te.pearson.service.StoresService;

@RestController
@RequestMapping("Store")
public class StoresController {
	
	@Autowired(required =true)
	private StoresService service;
	
	@GetMapping(path ="/getall")
	public ResponseEntity<ResponseBean> getall(@RequestParam String option){
		ResponseBean response = new ResponseBean(false, service.getall(option));
		return new ResponseEntity<ResponseBean>(response, HttpStatus.OK);
	}
	
	@GetMapping(path ="/getdata/{storeId}")
	public ResponseEntity<ResponseBean> getdata(@PathVariable String storeId){
		ResponseBean response = new ResponseBean(false, service.getData(storeId));
		return new ResponseEntity<ResponseBean>(response,HttpStatus.OK);
	}
	

}
