package com.ipp.findagame.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ipp.findagame.util.concurrent.UsageStatThreadPoolExecutor;

@Controller
@RequestMapping("/usagestat")
public class UsageStatController {

	// --
	UsageStatThreadPoolExecutor executor = UsageStatThreadPoolExecutor.getInstance();
	
	
	@RequestMapping(value="/{usageStateJson}", method = RequestMethod.GET)
	public void submitUsage(@PathVariable String usageStateJson){
		executor.sumitTask(usageStateJson);
	}
	
}
