package com.revature.controllers;

//import com.revature.models.USERS;
//import com.revature.services.LoginService;

import io.javalin.Javalin;

public interface Controller {
	
	//public USERS user = LoginService.user;

	public void addRoutes(Javalin app);
}
