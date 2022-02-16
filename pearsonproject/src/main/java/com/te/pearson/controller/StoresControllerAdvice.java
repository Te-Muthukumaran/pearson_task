package com.te.pearson.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.pearson.bean.ResponseBean;
import com.te.pearson.exception.CustomException;

@RestControllerAdvice
public class StoresControllerAdvice {

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ResponseBean> customException(CustomException cus) {
		ResponseBean response = new ResponseBean(true, cus.getMessage());
		return new ResponseEntity<ResponseBean>(response, HttpStatus.NOT_FOUND);
	}

}
