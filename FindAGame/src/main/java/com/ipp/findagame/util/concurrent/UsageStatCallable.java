package com.ipp.findagame.util.concurrent;

import java.util.concurrent.Callable;

import com.ipp.findagame.model.UsageStatData;

public class UsageStatCallable implements Callable<Boolean> {

	private String usageStatDataJson;
	
	public UsageStatCallable(String data) {
		this.usageStatDataJson = data;
	}
	/**
	 * This method will dump the web site
	 * usage statistics into database
	 */
	@Override
	public Boolean call() throws Exception {
		//TODO List
		// Serialize the json into  UsageStatData
		// create DAO classes and dump data 
		new  UsageStatData();
		
		return null;
	}
}