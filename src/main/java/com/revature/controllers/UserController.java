package com.revature.controllers;

import com.revature.models.LoggedIn;
import com.revature.models.UserDTO;
import com.revature.services.LoginService;
import com.revature.services.RoleService;
import com.revature.services.UserService;
import com.revature.utils.HibernateUtil;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class UserController implements Controller{

	//private UserService userService = new UserService();
	private LoginService loginService = new LoginService();
	private RoleService roleService = new RoleService();
	
	private Handler login = (ctx) -> {
		UserDTO userDTO = ctx.bodyAsClass(UserDTO.class);
		
		
		
		if(loginService.login(userDTO)){
			log.info(userDTO.getUsername()+"has logged in");
			
				
			//HibernateUtil.closeSession();
			//HibernateUtil.getSession();
			LoggedIn.username = userDTO.getUsername();
			ctx.req.getSession();
			if(roleService.getRole(loginService.user).getUserRole().equals("manager")){
				ctx.status(201);
			}else {
				ctx.status(200);
			}		
		}else {
			//ctx.req.getSession().invalidate();
			ctx.status(401);
		}
		
		
	};
	
	
	public void addRoutes(Javalin app) {
		
		app.post("/login", this.login);
	}

}
