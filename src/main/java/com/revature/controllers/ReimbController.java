package com.revature.controllers;

import java.util.List;

import com.revature.services.ReimbursementService;
import com.revature.models.REIMBURSEMENT;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class ReimbController implements Controller{
	
	private ReimbursementService reimbService = new ReimbursementService();

	
	public Handler getAllReimbursements = (ctx) -> {
		
		//if(ctx.req.getSession(false) !=null) {
		List<REIMBURSEMENT> allList = reimbService.findAllReimb();
		
		
		ctx.json(allList);
		ctx.status(200);
		//}else {
		//	ctx.status(401);
		//}
		
	};
	
	public Handler createReimb = (ctx) -> {
		//if(ctx.req.getSession(false) !=null) {
		REIMBURSEMENT reimb = ctx.bodyAsClass(REIMBURSEMENT.class);
		if(reimbService.createReimb(reimb)) {
			ctx.status(201);
		}else {
			ctx.status(400);
		}
	//	}else {
		//	ctx.status(401);
		//}
	};
	
	public Handler updateReimb = (ctx) -> {
		//if(ctx.req.getSession(false) !=null) {
		REIMBURSEMENT reimb = ctx.bodyAsClass(REIMBURSEMENT.class);
		if(reimbService.updateReimb(reimb)) {
			ctx.status(200);
		}else {
			ctx.status(400);
		}
	//	}else {
		//	ctx.status(401);
	//	}
	};
	
	public Handler findReimbByUserID = (ctx)->{
	//	if(ctx.req.getSession(false) !=null) {
		String id = ctx.pathParam("userReimbID");
		try {
		int userID = Integer.parseInt(id);
		List<REIMBURSEMENT> singleReimbList = reimbService.findReimbByUserID(userID);
		ctx.json(singleReimbList);
		}catch(NumberFormatException e){
			e.printStackTrace();
			ctx.status(406);
		}
		//}else {
	//		ctx.status(401);
	//	}
	};
	
	public Handler findByID = (ctx)->{
		//if(ctx.req.getSession(false) !=null) {
		String id = ctx.pathParam("reimbID");
		try {
		int userID = Integer.parseInt(id);
		REIMBURSEMENT singleReimb = reimbService.findByID(userID);
		ctx.json(singleReimb);
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
		app.get("/reimbursements/user/:userReimbID", this.findReimbByUserID);
		app.post("/reimbursements", this.createReimb);
		app.put("/reimbursements",this.updateReimb);
		
	}

	
	
	
	
	
	
	
	
	
	
	
}
