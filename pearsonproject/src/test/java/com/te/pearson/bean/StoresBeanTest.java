package com.te.pearson.bean;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;

import org.apache.catalina.Store;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StoresBeanTest {
	
	String json = "{\"storeId\":null,\"postCode\":\"563322\",\"city\":\"Chennai\",\"address\":null,\"openedDate\":null,\"numberofdays\":0}";
	ObjectMapper mapper = new ObjectMapper();

	@Test
	void test() throws JsonProcessingException, ParseException {
		Storesbean bean = new Storesbean();
		bean.setCity("Chennai");
		bean.setPostCode("563322");
		
		System.out.println(mapper.writeValueAsString(bean));

		Storesbean readValue = mapper.readValue(json, Storesbean.class);

		assertEquals(json, mapper.writeValueAsString(readValue));
	}

}
