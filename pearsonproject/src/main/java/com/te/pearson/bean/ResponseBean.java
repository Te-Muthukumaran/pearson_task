package com.te.pearson.bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseBean implements Serializable{
	
	private boolean err;
	
	private Object data;

}
