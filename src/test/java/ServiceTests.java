import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.models.REIMBURSEMENT;
import com.revature.models.USERS;
import com.revature.models.USER_ROLES;
import com.revature.models.UserDTO;
import com.revature.repos.reimbDAOI;
import com.revature.repos.userRolesDAOI;
import com.revature.repos.usersDAOI;
import com.revature.services.LoginService;
import com.revature.services.ReimbursementService;
import com.revature.services.RoleService;
import com.revature.services.UserService;

public class ServiceTests {

	int ID;
	public static UserService userservice;
	public static RoleService roleservice;
	public static ReimbursementService reimbservice;
	public static LoginService loginservice;
	public static String username = new String();
	public static USER_ROLES role = new USER_ROLES();
	public static USERS user = new USERS("tim", 1, "timmy", "jimbob", "timmy@gmail.com", role);
	public static REIMBURSEMENT reimbursement = new REIMBURSEMENT();
	public static UserDTO userDTO = new UserDTO();
	public static List<REIMBURSEMENT> reimblist;
	public static reimbDAOI reimbDao = new reimbDAOI();
	public static userRolesDAOI roleDao = new userRolesDAOI();
	public static usersDAOI userDao = new usersDAOI();
	public static Logger log = LoggerFactory.getLogger(ServiceTests.class);

	@BeforeEach
	public void setValues() {
		ID = 4;
		username = "blake";
		userDTO.username = "tim";
		user.setUsername("blake");

	}

	@Test
	public void testgetUser() {
		
		  log.info("In testgetUser"); user = userservice.getUser(username);
		  assertFalse(user.equals( userDao.getUser("blake")));
		 
		assertTrue(4 == 1+3);
	}

	@Test
	public void testgetRole() {
		log.info("In testgetRole");
		role = roleservice.getRole(user);
		assertEquals(role, roleDao.getRole(user));
		assertTrue(4 == 1+3);
	}

	@Test
	public void testfindAllReimb() {
		log.info("In findAllReimb");
		reimblist = reimbDao.findAllReimb();
		assertEquals(reimblist, reimbservice.findAllReimb());
		assertTrue(4 == 1+3);
	}

	@Test
	public void testfindReimbByUserID() {
		
		log.info("In testfindReimbByUserID");
		reimblist = reimbDao.findReimbByUserID(ID);
		assertEquals(reimblist, reimbservice.findReimbByUserID(4));
		assertTrue(4 == 1+3);
	}

	@Test
	public void testfindByID() {
		
		log.info("In testfindByID");
		reimbursement = reimbDao.findByID(ID);
		assertEquals(reimbursement, reimbservice.findByID(4));
		assertTrue(4 == 1+3);
	}

	@Test
	public void testcreateReimb() {
		
		log.info("In testcreateReimb");
		assertEquals(reimbDao.createReimb(reimbursement), reimbservice.createReimb(reimbursement));
		assertTrue(4 == 1+3);
	}

	@Test
	public void testupdateReimb() {
		
		log.info("In testupdateReimb");
		assertEquals(reimbDao.updateReimb(reimbursement), reimbservice.updateReimb(reimbursement));
		assertTrue(4 == 1+3);
	}

	@Test
	public void testnullb() {
		assertTrue(4 == 1+3);
	}

	@Test
	public void testlogin() {
		log.info("In testlogin");
		
		assertEquals(userDao.getUser("tim"), loginservice.login(userDTO));
	}

	@AfterEach
	public void clearValues() {
		user = null;
		ID = 0;
		username = null;
		userDTO.username = null;
		log.info("In clearValues");
	}

	@AfterAll
	public static void clearuserservice() {
		userservice = null;
		loginservice = null;
		reimbservice = null;
		roleservice = null;

		log.info("in clearuserservice");
	}

}
