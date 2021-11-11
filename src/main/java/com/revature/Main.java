package com.revature;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

//import java.util.Date;

import com.revature.controllers.Controller;
import com.revature.controllers.ReimbController;
import com.revature.controllers.UserController;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class Main {

	private static Javalin app;
	
	public static void main(String[] args) {
		
		/*
		 * try { URL myURL = new
		 * URL("http://mybucketforprojects.s3-website.us-east-2.amazonaws.com/");
		 * URLConnection myURLConnection = myURL.openConnection();
		 * myURLConnection.connect(); } catch (MalformedURLException e) { // new URL()
		 * failed // ... } catch (IOException e) { // openConnection() failed // ... }
		 */
		
		
		app = Javalin.create((config)->{
			config.addStaticFiles("/static2", Location.CLASSPATH);
			//config.addSinglePageRoot("http://mybucketforprojects.s3-website.us-east-2.amazonaws.com/", "http://mybucketforprojects.s3-website.us-east-2.amazonaws.com/");
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
