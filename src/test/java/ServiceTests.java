import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.models.REIMBURSEMENT;
import com.revature.models.USERS;
import com.revature.repos.usersDAOI;
import com.revature.services.ReimbursementService;
import com.revature.services.UserService;

public class ServiceTests {
	
	public static UserService userservice;
	public static ReimbursementService reimb;
	public static int ID;
	public static String name;
	public static USERS user;
	public static String pass;
	public static int type;
	public static boolean boo;
	public static ArrayList<REIMBURSEMENT> list = new ArrayList<REIMBURSEMENT>();
	public static usersDAOI userDao = new usersDAOI();
	public static Logger log = LoggerFactory.getLogger(ServiceTests.class);
	
	
	
	@BeforeEach
	public void setValues() {
		ID= 4;
		name = "jibob";
		pass = "Biggy";
		type = 1;
		boo = true;
		log.info("In setValues");
	}
	
	@Test
	public void testfindAllUsers() {
		log.info("In testfindAllUsers");
		//list = (ArrayList<REIMBURSEMENT>) reimb.findAllReimb();
		//assertEquals(list, reimb.findAllReimb());
	}
	
	@Test
	public void testfindByID() {
		log.info("In testfindByID");
		//user = userservice.getUser(Integer.toString(ID));
		//assertEquals(user, userDao.getUser("4"));
	}
	
	@Test
	public void testfindByName() {
		log.info("In testfindByName");
		//user = UserService.findByName(name);
		//assertEquals(user, userDao.findByName("jibob"));
	}
	
	@Test
	public void testnewUser() {
		log.info("In testnewUser");
		//boo = UserService.newUser(user);
		//assertEquals(boo, userDao.addUser(user));
	}
	
	@Test
	public void testcheckPass() {
		log.info("In testcheckPass");
		//boo = UserService.checkPass(pass, user);
		//assertEquals(boo, userDao.checkPass("biggy", user));
	}
	
	@Test
	public void testchangeType() {
		log.info("In testfindAllUsers");
		//boo = UserService.changeType(name, type);
		//assertEquals(boo, userDao.changeType("jibob", 1));
	}
	
	
	@AfterEach
	public void clearValues() {
		user = null;
		list = null;
		boo = false;
		log.info("In clearValues");
	}
	
	@AfterAll 
	public static void clearuserservice() {
		userservice = null;
		log.info("in clearuserservice");
	}
	

}
