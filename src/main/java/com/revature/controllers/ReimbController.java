package com.revature.controllers;

import java.util.List;

import com.revature.services.LoginService;
import com.revature.services.ReimbursementService;
import com.revature.models.REIMBURSEMENT;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class ReimbController implements Controller{
	
	private ReimbursementService reimbService = new ReimbursementService();

	
	public Handler getAllReimbursements = (ctx) -> {
		
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
		//if(ctx.req.getSession(false) !=null) {
		REIMBURSEMENT reimb = ctx.bodyAsClass(REIMBURSEMENT.class);
		reimb.setAuthor(LoginService.user);
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
		//if(ctx.req.getSession(false) !=null) {
		List<REIMBURSEMENT> allReimb = reimbService.findAllReimb();
		REIMBURSEMENT newreimb = ctx.bodyAsClass(REIMBURSEMENT.class);
		REIMBURSEMENT singleReimb = reimbService.findByID(newreimb.getAmount());
		REIMBURSEMENT reimb = singleReimb;
		for(REIMBURSEMENT r : allReimb) {
			
			if(r.getReimbID() == newreimb.getAmount()) {
				reimb.setResolved(newreimb.getResolved());
				reimb.setStatus(newreimb.getStatus());
				
				if(reimbService.updateReimb(reimb)){
					ctx.status(200);
				}else {
					ctx.status(400);
				}
				
			}
			
		}
		
		
	//	}else {
		//	ctx.status(401);
	//	}
	};
	
	public Handler findReimbByUserID = (ctx)->{
	//	if(ctx.req.getSession(false) !=null) {
		int id = LoginService.user.getUsersID();
		//try {
		//int userID = Integer.parseInt(id);
		List<REIMBURSEMENT> singleReimbList = reimbService.findReimbByUserID(id);
		ctx.json(singleReimbList);
		ctx.status(200);
		//}catch(NumberFormatException e){
		//	e.printStackTrace();
		//	ctx.status(406);
		//}
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
