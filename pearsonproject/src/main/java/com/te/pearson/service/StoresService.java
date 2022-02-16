package com.te.pearson.service;

import java.util.List;

import com.te.pearson.bean.Storesbean;

public interface StoresService {

	public List<Storesbean> getall(String option);

	public Object getData(String storeId);

}
