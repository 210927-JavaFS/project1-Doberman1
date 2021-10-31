package com.revature.controllers;

import com.revature.services.UserService;

import io.javalin.Javalin;

public class UserController implements Controller{

	private UserService userService = new UserService();
	
	//+public Handler 
	
	
	public void addRoutes(Javalin app) {
		
		
	}

}
