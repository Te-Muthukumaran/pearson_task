package com.te.pearson.bean;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.opencsv.bean.CsvBindAndJoinByName;
import com.opencsv.bean.CsvDate;

import lombok.Data;

@Data
public class Storesbean implements Serializable{
	
	
	private String storeId;
	
	private String postCode;
	
	private String city;
	
	private String address;
	
	private String openedDate;
	
	private long numberofdays;

}
