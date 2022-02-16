package com.te.pearson.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;

import com.opencsv.CSVReader;
import com.te.pearson.bean.Storesbean;

public class StoresServiceImplTest {
	
	CSVReader reader;
	@InjectMocks
	
	private StoresServiceImpl service;

	public StoresServiceImplTest() {
		reader = mock(CSVReader.class);
	}

	@Test
	void testGetStoreById() throws IOException {
		Storesbean store = new Storesbean();
		store.setAddress("guindy");
		store.setCity("chennai");
		store.setStoreId("1525eec4-7bed-4597-bf5a-e06fcede5f4f");
		store.setNumberofdays(53153453354354L);
		store.setOpenedDate("12-05-1995");
		store.setPostCode("600077");
		
		//assertEquals("1525eec4-7bed-4597-bf5a-e06fcede5f4f", service.getData(store.getStoreId()).getStoreId());
	}

	@Test
	void getall() throws IOException {

		Storesbean store = new Storesbean();
		store.setAddress("krt");
		store.setCity("bangalore");
		store.setPostCode("563322");
		store.setStoreId("12");
		String[] abc = { "12", "563322", "bangalore", "krt" };

		List<Storesbean> list = new ArrayList<>();
		list.add(store);
		CSVReader csvReader = new CSVReader(new FileReader("C:\\Users\\Muthu\\Desktop\\stores.csv"));

//		when(service.getStoreById(store.getStoreId())).thenReturn(store);

		//assertEquals("1525eec4-7bed-4597-bf5a-e06fcede5f4f", service.getall("city").get(0).getStoreId());

	}

}
