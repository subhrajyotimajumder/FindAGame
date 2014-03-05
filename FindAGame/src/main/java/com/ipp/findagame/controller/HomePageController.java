package com.ipp.findagame.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ipp.findagame.model.Player;

@Controller
@RequestMapping("/")
public class HomePageController{
	
	static final Logger logger = Logger.getLogger(HomePageController.class);
	private long i = 0;
	/**
	 * web page response
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/welcome", method = RequestMethod.GET)
	public String welcome(ModelMap model) {
		logger.debug("welcome start");
		model.addAttribute("message", "whatsup!");
		logger.debug("welcome end");
		return "index";
	}
	
	/**
	 * json response 
	 * 
	 */
	@RequestMapping("player")
    public @ResponseBody Player getDummyPlayer(ModelMap model){
		Player player = new Player();
		player.setId(i++);
		player.setName("Dummy");
        return player;
    }
}
