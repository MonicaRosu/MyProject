package ro.jademy.sixJars.business.service;

import ro.jademy.sixJars.business.entities.User;
import ro.jademy.sixJars.persistance.DAO.UserDAO;

public class LoginService {

//	private static final LoginService soleInstance = new LoginService();
	
	public User doLogin(String userName, String password) {

		UserDAO userDAO = new UserDAO();
		User user = userDAO.getUserByUsername(userName);

		if (user == null) {
			return null;
		}
		if (!user.getPassword().equals(password)) {
			return null;

		}
		return user;
	}

//	public static LoginService getSoleinstance() {
//		return soleInstance;
//	}

   public User changePassword(String username, String password){
	
	 
	   
	   
	   return null;
	   
	   
   }
}
