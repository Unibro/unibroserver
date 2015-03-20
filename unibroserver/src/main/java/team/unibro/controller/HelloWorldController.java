package team.unibro.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import team.unibro.model.User;
import team.unibro.service.IUserService;

@Controller
public class HelloWorldController {

	private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);
	
	@Autowired
	private IUserService userService;
 
	@RequestMapping("/test2")
	public @ResponseBody List<User> showIndex() {
		logger.info("/test2");
		if(userService == null) logger.info("userService is null.");
		return userService.getAllUser();
	}
	
	@RequestMapping("/test1")
	public String showMessage() {
		System.out.println("test1");
		  
	    return "hello";
	}
}