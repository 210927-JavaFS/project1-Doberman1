package com.revature;

//import java.util.Date;

import com.revature.controllers.Controller;
import com.revature.controllers.ReimbController;
import com.revature.controllers.UserController;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class Main {

	private static Javalin app;
	
	public static void main(String[] args) {
		
		
		app = Javalin.create((config)->{
			config.addStaticFiles("/static2", Location.CLASSPATH);
		});
		
		configure(new ReimbController(), new UserController());
		
		app.start(8081);
		
		//System.out.println(new Date(System.currentTimeMillis()));

	}
	
	private static void configure(Controller... controllers) {
		for(Controller c: controllers) {
			
			c.addRoutes(app);
		}
		
	}

}
