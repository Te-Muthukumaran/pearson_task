package com.te.pearson.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import com.te.pearson.bean.Storesbean;
import com.te.pearson.exception.CustomException;

@Service

public class StoresServiceImpl implements StoresService {

	@Override
	public List<Storesbean> getall(String option) {

		List<Storesbean> result = null;

		Map<String, String> mapping = new HashMap<String, String>();
		mapping.put("Store Id", "storeid");
		mapping.put("Post Code", "postcode");
		mapping.put("City", "city");
		mapping.put("Address", "address");
		mapping.put("Opened Date", "openeddate");

		HeaderColumnNameTranslateMappingStrategy<Storesbean> strategy = new HeaderColumnNameTranslateMappingStrategy<Storesbean>();
		strategy.setType(Storesbean.class);
		strategy.setColumnMapping(mapping);

		CSVReader csvReader = null;
		try {
			csvReader = new CSVReader(new FileReader("C:\\Users\\Muthu\\Desktop\\stores.csv"));
		} catch (FileNotFoundException e) {
			
			throw new CustomException(" Given Path is not available ");
		}
		CsvToBean csvToBean = new CsvToBean();

		List<Storesbean> list = csvToBean.parse(strategy, csvReader);

		for (Storesbean info : list) {
			Date givendate = null;
			try {
				givendate = new SimpleDateFormat("dd-MM-yyyy").parse(info.getOpenedDate());
				Date currentdate = new Date();

				long timediff = Math.abs(currentdate.getTime() - givendate.getTime());
				long difference = TimeUnit.DAYS.convert(timediff, TimeUnit.MILLISECONDS);

				info.setNumberofdays(difference);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (option.equalsIgnoreCase("city")) {
			result = list.stream().sorted((a, b) -> a.getCity().compareTo(b.getCity())).collect(Collectors.toList());
		} else if (option.equalsIgnoreCase("openedDate")) {
			result = list.stream().sorted((a, b) -> a.getOpenedDate().compareTo(b.getOpenedDate()))
					.collect(Collectors.toList());
		}
		return result;
	}

	@Override
	public Object getData(String storeId) {
		Map<String, String> mapping = new HashMap<String, String>();
		mapping.put("Store Id", "storeid");
		mapping.put("Post Code", "postcode");
		mapping.put("City", "city");
		mapping.put("Address", "address");
		mapping.put("Opened Date", "openeddate");

		HeaderColumnNameTranslateMappingStrategy<Storesbean> strategy = new HeaderColumnNameTranslateMappingStrategy<Storesbean>();
		strategy.setType(Storesbean.class);
		strategy.setColumnMapping(mapping);

		CSVReader csvReader = null;
		try {
			csvReader = new CSVReader(new FileReader("C:\\Users\\Muthu\\Desktop\\stores.csv"));
		} catch (FileNotFoundException e) {
			throw new CustomException(" Given Path Not Found");

		}
		CsvToBean csvToBean = new CsvToBean();

		List<Storesbean> storebean = csvToBean.parse(strategy, csvReader);
		Storesbean result = null;

		for (Storesbean storesbean : storebean) {
			if (storesbean.getStoreId().equals(storeId)) {
				result = storesbean;
			}
		}

		if (result != null) {
			return result;
		} else {
			throw new CustomException(" Id Not Available ");
		}

	}

}
