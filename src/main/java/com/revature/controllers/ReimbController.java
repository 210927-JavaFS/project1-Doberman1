package com.revature.controllers;

import java.util.Date;
import java.util.List;

import com.revature.services.LoginService;
import com.revature.services.ReimbursementService;
import com.revature.services.UserService;
import com.revature.models.LoggedIn;
import com.revature.models.REIMBURSEMENT;
import com.revature.models.UserDTO;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class ReimbController implements Controller{
	
	private ReimbursementService reimbService = new ReimbursementService();

	
	public Handler getAllReimbursements = (ctx) -> {
		log.info("getting all reimbursements");
		
		//if(ctx.req.getSession(false) !=null) {
		List<REIMBURSEMENT> allList = reimbService.findAllReimb();
		
		if(allList!=null) {
		ctx.json(allList);
		ctx.status(200);
		//}else {
		//	ctx.status(401);
		//}
		}else {
			ctx.status(400);
		}
	};
	
	public Handler createReimb = (ctx) -> {
		log.info("creating new reimbursement");
		//if(ctx.req.getSession(false) !=null) {
		REIMBURSEMENT reimb = ctx.bodyAsClass(REIMBURSEMENT.class);
		reimb.setAuthor(UserService.getUser(reimb.getAuthor().getUsername()));
		reimb.setResolved(null);
		
		if(reimb.getType().getReimbTypeID() == 1) {
			reimb.getType().setReimbType("lodging");
		}else if(reimb.getType().getReimbTypeID() == 2) {
			reimb.getType().setReimbType("travel");
		}else if(reimb.getType().getReimbTypeID() == 3) {
			reimb.getType().setReimbType("food");
		}else if(reimb.getType().getReimbTypeID() == 4) {
			reimb.getType().setReimbType("other");
		}else {
			System.out.println("Problem with create in the controller");
		}
		
		System.out.println(reimb);
		//Date n = null;
		//reimb.setResolved(n);
		if(reimbService.createReimb(reimb)) {
			ctx.status(200);
		}else {
			ctx.status(400);
		}
	//	}else {
		//	ctx.status(401);
		//}
	};
	
	public Handler updateReimb = (ctx) -> {
		log.info("updating reimbursement");
		//if(ctx.req.getSession(false) !=null) {
		System.out.println("1");
		List<REIMBURSEMENT> allReimb = reimbService.findAllReimb();
		REIMBURSEMENT newreimb = ctx.bodyAsClass(REIMBURSEMENT.class);
		//REIMBURSEMENT oldReimb = reimbService.findByID(newreimb.getAmount());
		REIMBURSEMENT reimb = reimbService.findByID(newreimb.getAmount());
		for(REIMBURSEMENT r : allReimb) {
			
			if(r.getReimbID() == newreimb.getAmount()) {
				reimb.setResolved(newreimb.getResolved());
				reimb.setStatus(newreimb.getStatus());
				reimb.setResolver(UserService.getUser(LoggedIn.username));
				//reimb.setSubmitted(null);
				
				if(reimb.getStatus().getReimbStatusID() == 2) {
					reimb.getStatus().setReimbStatus("approved");
				}else if(reimb.getStatus().getReimbStatusID() == 3) {
					reimb.getStatus().setReimbStatus("denied");
				}else if(reimb.getStatus().getReimbStatusID() == 4) {
					reimb.getStatus().setReimbStatus("pending");
				}else {
					System.out.println("Problem with update in the controller");
				}
				
			}
			
		}
		System.out.println("2");
		System.out.println(newreimb);
		System.out.println("3");
		System.out.println(reimb);
		
		System.out.println("in updateReimb");
		System.out.println("in updateReimb");
		System.out.println("in updateReimb");
		
		if(reimbService.updateReimb(reimb)){
			ctx.status(200);
		}else {
			ctx.status(400);
		}
		
		System.out.println("in updateReimb");
		System.out.println("in updateReimb");
		
	//	}else {
		//	ctx.status(401);
	//	}
	};
	
	public Handler findReimbByUserID = (ctx)->{
		log.info("getting all reimbursements for a single user");
	//	if(ctx.req.getSession(false) !=null) {
		int id = UserService.getUser(LoggedIn.username).getUsersID();
		
		//int userID = Integer.parseInt(id);
		List<REIMBURSEMENT> singleReimbList = reimbService.findReimbByUserID(id);
		ctx.json(singleReimbList);
		ctx.status(200);
		
		//}else {
	//		ctx.status(401);
	//	}
	};
	
	public Handler findByID = (ctx)->{
		log.info("finding reimbursement by its id");
		//if(ctx.req.getSession(false) !=null) {
		String id = ctx.pathParam("reimbID");
		try {
		int userID = Integer.parseInt(id);
		REIMBURSEMENT singleReimb = reimbService.findByID(userID);
		ctx.json(singleReimb);
		ctx.status(200);
		}catch(NumberFormatException e){
			e.printStackTrace();
			ctx.status(406);
		}
	//	}else {
		//	ctx.status(401);
	//	}
	};
	
	
	@Override
	public void addRoutes(Javalin app) {
		app.get("/reimbursements", this.getAllReimbursements);
		app.get("/reimbursements/:reimbID", this.findByID);
		app.get("/userinfo", this.findReimbByUserID);
		app.post("/reimbursements", this.createReimb);
		app.put("/reimbursements",this.updateReimb);
		
	}
	
	
	
	
}
