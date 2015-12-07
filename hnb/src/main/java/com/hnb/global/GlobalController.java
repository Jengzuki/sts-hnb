package com.hnb.global;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hnb.main.MainController;
@Controller
@RequestMapping("/global")
public class GlobalController {
private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	

	@RequestMapping("/main")
	public String main(){
		return "global/main";
	}
	
	@RequestMapping("/header")
	public String header(){
		return "global/header";
	}
	@RequestMapping("/jumbotron")
	public String jumbotron(){
		return "global/jumbotron";
	}
	@RequestMapping("/footer")
	public String footer(){
		return "global/footer";
	}
}
