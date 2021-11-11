Create Database project_1;

INSERT INTO hibernate.user_roles (userroleid,userrole)
	VALUES (1,'employee');
INSERT INTO hibernate.user_roles (userroleid,userrole)
	VALUES (2,'manager');

INSERT INTO hibernate.reimbursement_type (reimbtypeid,reimbtype)
	VALUES (1,'lodging');
INSERT INTO hibernate.reimbursement_type (reimbtypeid,reimbtype)
	VALUES (2,'food');
INSERT INTO hibernate.reimbursement_type (reimbtypeid,reimbtype)
	VALUES (3,'travel');
INSERT INTO hibernate.reimbursement_type (reimbtypeid,reimbtype)
	VALUES (4,'other');

INSERT INTO hibernate.reimbursement_status (reimbstatusid)
	VALUES (1);
INSERT INTO hibernate.reimbursement_status (reimbstatusid,reimbstatus)
	VALUES (2,'approved');
INSERT INTO hibernate.reimbursement_status (reimbstatusid,reimbstatus)
	VALUES (3,'denied');
INSERT INTO hibernate.reimbursement_status (reimbstatusid,reimbstatus)
	VALUES (4,'pending');

INSERT INTO hibernate.users (usersid,email,firstname,lastname,"password",username,userroleid)
	VALUES (1,'Tim@revature.net','Timmy','Jimbob','-268132974','tim',1);
INSERT INTO hibernate.users (usersid,email,firstname,lastname,"password",username,userroleid)
	VALUES (2,'Penny@yahoo.com','Penny','Smith','-268132974','penny',1);
INSERT INTO hibernate.users (usersid,email,firstname,lastname,"password",username,userroleid)
	VALUES (3,'Bob@gmail.com','Bobby','Barker','-268132974','bob',1);
INSERT INTO hibernate.users (usersid,email,firstname,lastname,"password",username,userroleid)
	VALUES (4,'Blake@hotmail.com','Blake','Dobbs','1216985755','blake',2);









INSERT INTO user_roles VALUES ('employee');
	
INSERT INTO USER_ROLES
	VALUES ('manager');