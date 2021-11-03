package com.revature.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import com.revature.models.USERS;
//import com.revature.services.LoginService;

import io.javalin.Javalin;

public interface Controller {
	
	//public USERS user = LoginService.user;
	public static Logger log = LoggerFactory.getLogger(Controller.class);
	
	public void addRoutes(Javalin app);
}
